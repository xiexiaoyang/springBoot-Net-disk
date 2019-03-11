package com.yang.pan.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Login {
    @Id
    @GeneratedValue
    private Integer lid;
    @NotEmpty(message = "用户名不能为空")
    @Column(unique = true)
    private String uname;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public Login() {
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
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

    @Override
    public String toString() {
        return "Login{" +
                "lid=" + lid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
