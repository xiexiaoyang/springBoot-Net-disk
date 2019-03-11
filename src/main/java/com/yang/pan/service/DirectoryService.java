package com.yang.pan.service;

import com.yang.pan.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DirectoryService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DirectoryRepository directoryRepository;
    @Autowired
    private FileRepository fileRepository;

    /**
     * 添加目录
     * @param directory
     * @return
     */
    public Directory addDir(Directory directory){
        directory.setModifieddate(new Date());
        directory.setCreatedate(new Date());
        return directoryRepository.save(directory);
    }

    /**
     * 通过id删除目录
     * @param did
     */
    public void deleteDir(Integer did){
        directoryRepository.delete(did);
    }

    /**
     * 修改目录
     * @param directory
     * @return
     */
    public Directory updateDir(Directory directory){
        directory.setModifieddate(new Date());
        Directory dir = directoryRepository.findOne(directory.getDid());
        directory.setCreatedate(dir.getCreatedate());
        return directoryRepository.save(directory);
    }

    /**
     * 查询目录列表
     * @param uname
     * @param updid
     * @return
     */
    public List<Directory> getDir(String uname,Integer updid){
       return directoryRepository.findAllByUnameAndUpdirid(uname,updid);
    }
}
