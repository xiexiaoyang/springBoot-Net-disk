package com.yang.pan.controller;

import com.yang.pan.domain.File;
import com.yang.pan.domain.User;
import com.yang.pan.service.FileService;
import com.yang.pan.service.UserService;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadController {
    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;
    private final static Logger logger  = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    private UserService userService ;
    @Autowired
    private FileService fileService ;
    @PostMapping("/singlefile/{uid}")
    public Result singleFileUpload(@RequestParam("file") MultipartFile file,
                                   @PathVariable("uid") Integer uid) {
        //logger.info("传入的文件参数：{}", JSON.toJSONString(myFile.getFile(), true));
        String contentType = file.getContentType();   //文件类型
        String fileName = file.getOriginalFilename();  //名字
        long fileSize = file.getSize();
        System.out.println(contentType);
        //获取用户信息
        System.out.println("uid  "+uid);
        User user = userService.getUser(uid);
        //类型转换
        if(contentType.contains("video")){
            contentType = "视频";
        }else if(contentType.contains("text")){
            contentType = "文本";
        }else if(contentType.contains("image")){
            contentType = "图片";
        }else if(contentType.contains("audio")){
            contentType = "音乐";
        }
        else{
            contentType="其他";
        }
        System.out.println(contentType+" "+ fileName + "  "+fileSize);
        //设置文件保存路径
        String downFilePath = "./files/"+user.getUname()+"/";
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.info("文件为空");
            return ResultUtil.error(-1,"文件为空，请重新上传");
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(downFilePath + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(downFilePath));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            logger.info("文件写入成功...");

            File file1 = new File();
            file1.setFilesize(BigInteger.valueOf (fileSize));
            file1.setFiletype(contentType);
            file1.setFilename(fileName);
            file1.setUname(user.getUname());
            file1.setUpdirid(user.getUid());
            file1.setFilepath(path.toString());
            System.out.println(file1.getFiletype());
            File file2= fileService.uploadFile(file1);

            return ResultUtil.error(-1,"文件上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(-1,"后端异常...");
        }
    }
   @GetMapping(value = "/getUid/{uid}")
    public Result getUid (@PathVariable("uid") Integer uid) {
       System.out.println("-------------------getUid------------------------------");
       User user = userService.getUser(uid);
       System.out.println("uid:" + uid);
       String filepath = "./temp";
       java.io.File file = new java.io.File(filepath);
       java.io.File[] fileList = file.listFiles();
       System.out.println("文件名   " + fileList[0].getName());

       String fileName = fileList[0].getName();

       String startPath = "./temp/" + fileName;
       String endPath = "./files/" + user.getUname();
       try {
           java.io.File startFile = new java.io.File(startPath);
           java.io.File tmpFile = new java.io.File(endPath);//获取文件夹路径
           if (!tmpFile.exists()) {//判断文件夹是否创建，没有创建则创建新文件夹
               tmpFile.mkdirs();
           }
           System.out.println(endPath + startFile.getName());
           if (startFile.renameTo(new java.io.File(endPath + "/" + startFile.getName()))) {
               System.out.println("File is moved successful!");
               logger.info("文件移动成功！文件名：《{}》 目标路径：{}", fileName, endPath);

               File file1 = fileService.getFilebyfname(startFile.getName());
               file1.setUpdirid(user.getUid());
               file1.setUname(user.getUname());
               file1.setFilepath(endPath + "/" + startFile.getName());
               fileService.uploadFile(file1);
               return ResultUtil.success();


           } else {
               System.out.println("File is failed to move!");
               logger.info("文件移动失败！文件名：《{}》 起始路径：{}", fileName, startPath);
               return ResultUtil.error(-1, "文件移动失败！");
           }
       } catch (Exception e) {
           logger.info("文件移动异常！文件名：《{}》 起始路径：{}", fileName, startPath);
           return ResultUtil.error(-1, "文件移动失败！");

       }
   }



}