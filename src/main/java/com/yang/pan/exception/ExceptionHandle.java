package com.yang.pan.exception;

import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.PanException;
import com.yang.pan.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof PanException){
            PanException panException=(PanException)e;
            return ResultUtil.error(panException.getCode(),panException.getMessage());
        }else{
            logger.info("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
