package com.bbsstep.po;

import java.util.Date;

public class TUser {
    private Long id;

    private String username;

    private String pwd;

    private Integer status;

    private String nickname;

    private String tel;

    private Integer ismobile;

    private String iconurl;

    private Integer usertype;

    private String wyname;

    private String wypwd;

    private Date createdate;

    private Date updatedate;

    private Integer bigv;

    private String hxcontent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Integer getIsmobile() {
        return ismobile;
    }

    public void setIsmobile(Integer ismobile) {
        this.ismobile = ismobile;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl == null ? null : iconurl.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getWyname() {
        return wyname;
    }

    public void setWyname(String wyname) {
        this.wyname = wyname == null ? null : wyname.trim();
    }

    public String getWypwd() {
        return wypwd;
    }

    public void setWypwd(String wypwd) {
        this.wypwd = wypwd == null ? null : wypwd.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getBigv() {
        return bigv;
    }

    public void setBigv(Integer bigv) {
        this.bigv = bigv;
    }

    public String getHxcontent() {
        return hxcontent;
    }

    public void setHxcontent(String hxcontent) {
        this.hxcontent = hxcontent == null ? null : hxcontent.trim();
    }
}