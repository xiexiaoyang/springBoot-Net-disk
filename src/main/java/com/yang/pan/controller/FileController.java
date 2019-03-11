package com.yang.pan.controller;

import com.yang.pan.domain.File;
import com.yang.pan.service.FileService;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Configuration
public class FileController {
    @Autowired
    private FileService fileService;
//加载文件目录
@GetMapping(value = "/fall/{uid}")
    public Result getUserFile(@PathVariable("uid") Integer uid){

        return ResultUtil.success(fileService.getUserFile(uid));
    }
//文件上传
    @PostMapping("/file")
    public Result uploadFile(@Valid File file){
        return ResultUtil.success(fileService.uploadFile(file));
    }

//下载
    @GetMapping("/file/{fid}")
    public Result downloadFile(@PathVariable("fid")Integer fid){
        return ResultUtil.success(fileService.downloadFile(fid));
    }
//修改文件名称
    @PutMapping("/file/{fid}")
    public Result renameFile(@Valid File file){
        System.out.println("11111"+file.getFilename());
        return ResultUtil.success(fileService.renameFile(file));
    }
//删除
    @DeleteMapping("/file/{fid}")
    public Result deleteFile(@PathVariable("fid")Integer fid){
        fileService.deleteFile(fid);
        return  ResultUtil.success();
    }
//移动
//复制


}
