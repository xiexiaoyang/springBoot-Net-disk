package com.yang.pan.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginInput {
    @NotEmpty(message = "用户名不能为空")
    private String uname;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public LoginInput() {
    }

    @Override
    public String toString() {
        return "LoginInput{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
