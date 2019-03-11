package com.yang.pan.controller;

import com.yang.pan.domain.Directory;
import com.yang.pan.service.DirectoryService;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DirectoryController {
    @Autowired
    private DirectoryService directoryService;

    /**
     * 添加目录
     * @param directory
     * @return
     */
    @PostMapping(value = "/dir")
    public Result addDir(@Valid Directory directory){

        return ResultUtil.success(directoryService.addDir(directory));
    }

    /**
     * 通过id删除目录
     * @param did
     */
    @DeleteMapping(value = "/dir/{did}")
    public void deleteDir(@PathVariable("did")Integer did){
        directoryService.deleteDir(did);
    }

    /**
     * 修改目录
     * @param directory
     * @return
     */
    @PutMapping(value = "/dir/{did}")
    public Result updateDir(Directory directory){
        return ResultUtil.success(directoryService.updateDir(directory));
    }

    /**
     * 查询目录列表
     * @param uname
     * @param updid
     * @return
     */
    @GetMapping(path = "/dir/{uname}/updid/{updid}")
    public Result getDir(@PathVariable("uname")String uname,@PathVariable("updid")Integer updid){
       return ResultUtil.success( directoryService.getDir(uname,updid));
    }
}
