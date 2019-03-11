package com.yang.pan.vo;

import org.springframework.web.multipart.MultipartFile;

public class MyFile {
    private Integer uid;
    private String uname;
    private MultipartFile file;

    public MyFile() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
