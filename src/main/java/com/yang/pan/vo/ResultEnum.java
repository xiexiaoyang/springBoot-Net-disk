package com.yang.pan.vo;

public enum ResultEnum {
    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    UNAME_NOTEXISTENT(100,"用户不存在"),
    PASSWORD_ERROR(101,"密码不正确"),
    UNAME_HASEXISTENTED(102,"改用户名已被注册"),
    PASSWORD_NOTMATCH(103,"密码不匹配。请重新输入"),
    UNAME_UNCHANGE(104,"用户名不可修改"),
    ;

    private Integer code;
    private String smg;

    ResultEnum(Integer code, String smg) {
        this.code = code;
        this.smg = smg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSmg() {
        return smg;
    }

    public void setSmg(String smg) {
        this.smg = smg;
    }
}
