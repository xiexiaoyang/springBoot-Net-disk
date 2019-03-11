package com.yang.pan.utils;

import com.yang.pan.vo.Result;
import com.yang.pan.vo.ResultEnum;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(100);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result success(){
        return null;
    }
    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }

    public static Result error(ResultEnum resultEnum){
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getSmg());
        return result;
    }
}
