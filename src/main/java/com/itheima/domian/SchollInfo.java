package com.itheima.domian;

import java.io.Serializable;

public class SchollInfo implements Serializable {
    private String schollId;

    private String contacts;

    private String schollName;

    private String tel;

    private String email;

    private String delFlag;


    public String getSchollId() {
        return schollId;
    }

    public void setSchollId(String schollId) {
        this.schollId = schollId == null ? null : schollId.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getSchollName() {
        return schollName;
    }

    public void setSchollName(String schollName) {
        this.schollName = schollName == null ? null : schollName.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}