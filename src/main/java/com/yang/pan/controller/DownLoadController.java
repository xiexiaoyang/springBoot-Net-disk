package com.yang.pan.controller;

import com.yang.pan.service.FileService;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RestController
@CrossOrigin
public class DownLoadController {
    @Autowired
    FileService fileService;
    private final static Logger logger  = LoggerFactory.getLogger(DownLoadController.class);
    @RequestMapping(value = "/Download/{fid}", method = RequestMethod.GET)
    public Result Download(@PathVariable("fid") Integer fid, HttpServletResponse res) {
        //获取文件信息
        com.yang.pan.domain.File file = fileService.downloadFile(fid);
        String fileName = file.getFilename();
        String startPath = file.getFilepath();
        String endPath = "./down/"+file.getFilename();
        try {
            FileInputStream ins = new FileInputStream(file.getFilepath());
            FileOutputStream out = new FileOutputStream(endPath);
            byte[] b = new byte[1024];
            int n=0;
            while((n=ins.read(b))!=-1){
                out.write(b, 0, n);
            }

            ins.close();
            out.close();
            return ResultUtil.success(null);
        } catch (Exception e) {
            logger.info("文件移动异常！文件名：《{}》 起始路径：{}", fileName, startPath);
            return ResultUtil.error(-1, "文件移动失败！");

        }
    }
}
