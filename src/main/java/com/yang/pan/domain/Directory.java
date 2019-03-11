package com.yang.pan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Directory {
    @Id
    @GeneratedValue
    private Integer did;
    private String uname;

    private Integer updirid;
    private String dirname;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date modifieddate;

    public Directory() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUpdirid() {
        return updirid;
    }

    public void setUpdirid(Integer updirid) {
        this.updirid = updirid;
    }

    public String getDirname() {
        return dirname;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "did=" + did +
                ", uname='" + uname + '\'' +
                ", updirid=" + updirid +
                ", dirname='" + dirname + '\'' +
                ", createdate=" + createdate +
                ", modifieddate=" + modifieddate +
                '}';
    }
}
