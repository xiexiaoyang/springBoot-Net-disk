package com.yang.pan.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInput {
    @NotEmpty(message = "用户名不能为空")
    private String uname;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @NotEmpty(message = "再次输入密码不能为空")
    private String againpassword;
    private String sex;
    private String phone;
    private String email;
    private String introduction;

    public UserInput() {
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

    public String getAgainpassword() {
        return againpassword;
    }

    public void setAgainpassword(String againpassword) {
        this.againpassword = againpassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", againpassword='" + againpassword + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
