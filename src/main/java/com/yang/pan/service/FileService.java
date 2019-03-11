package com.yang.pan.service;

import com.yang.pan.domain.File;
import com.yang.pan.domain.FileRepository;
import com.yang.pan.vo.OutFile;
import com.yang.pan.vo.PanException;
import com.yang.pan.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public List<OutFile> getUserFile(Integer uid){
        List<File> fileList= fileRepository.findAllByUpdirid(uid);
        List<OutFile> outFiles = new LinkedList<OutFile>();
        if(fileList == null){
            throw new PanException(ResultEnum.UNAME_UNCHANGE);
        }

        for(File file: fileList){
            BigInteger size = file.getFilesize();
            OutFile outFile = new OutFile();
            String outSize = "";
            if(0<size.intValue()&&size.intValue()<1024){
                outSize = size.intValue()+"B";
            }else if(1024<size.intValue()&&size.intValue()<1024*1024){
                outSize = size.intValue()/1024+"KB";
            }else if(1024*1024<size.intValue()&&size.intValue()<1024*1024*1024){
                outSize = size.intValue()/1024/1024+"M";
            }else{

            }

            outFile.setFid(file.getFid());
            outFile.setFilesize(outSize);
            outFile.setCreatedate(file.getCreatedate());
            outFile.setModifieddate(file.getModifieddate());

            outFile.setFilename(file.getFilename());
            outFile.setFilepath(file.getFilepath());
            outFile.setFiletype(file.getFiletype());
            outFile.setIs_delete(file.isIs_delete());

            outFile.setUname(file.getUname());
            outFile.setUpdirid(file.getUpdirid());

            outFiles.add(outFile);

        }


        return outFiles;
    }
    /**
     * 上传文件
     * @param file
     * @return
     */
    public File uploadFile(File file){
        file.setCreatedate(new Date());
        file.setModifieddate(new Date());
        return fileRepository.save(file);
    }

    /**
     * 下载文件
     * @param fid
     * @return
     */
    public File downloadFile(Integer fid){
        return fileRepository.findOne(fid);
    }

    /**
     * 文件重命名
     * @param file
     * @return
     */
    public File renameFile(File file){
        file.setModifieddate(new Date());
        File file1 = fileRepository.findOne(file.getFid());
        file1.setModifieddate(new Date());


        System.out.println("2222222222222"+file1.getFilepath());
        java.io.File oldfile=new java.io.File(file1.getFilepath());
        java.io.File newfile=new java.io.File("./files/"+file1.getUname()+"/"+file.getFilename());
        if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            System.out.println(newfile.getName()+"已经存在！");
        else{
            oldfile.renameTo(newfile);
        }
        file1.setFilename(file.getFilename());
        file1.setFilepath("./files/"+file1.getUname()+"/"+file.getFilename());
        return fileRepository.save(file1);
    }

    public void deleteFile(Integer fid){
        File file1 = fileRepository.getOne(fid);
        String path = file1.getFilepath();
        java.io.File file=new java.io.File(path);
        if(file.exists()&&file.isFile())
            file.delete();
        fileRepository.delete(fid);
    }

    public File getFilebyfname(String filename){
        return fileRepository.findByFilename(filename);
    }
}
