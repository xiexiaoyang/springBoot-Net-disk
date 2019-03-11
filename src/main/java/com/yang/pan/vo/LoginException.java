package com.yang.pan.vo;
/*
自定义Login异常处理
 */
public class LoginException extends RuntimeException {
    private Integer code;

    public LoginException(ResultEnum resultEnum) {
        super(resultEnum.getSmg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
