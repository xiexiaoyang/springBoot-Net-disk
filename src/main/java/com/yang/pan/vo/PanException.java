package com.yang.pan.vo;
//自定义异常处理
public class PanException extends RuntimeException {
    private Integer code;

    public PanException(ResultEnum resultEnum) {
        super(resultEnum.getSmg());
        this.code = resultEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }
}
