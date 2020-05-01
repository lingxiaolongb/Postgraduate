package com.itheima.domian;

import java.io.Serializable;
import java.util.List;


public class SchollVacancy implements Serializable {
    private Long id;

    private String schollId;

    private String contacts;


    private String telephone;

    private String email;
    private String subName;

    private Integer vnumber;

    private String delFlag;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public Integer getVnumber() {
        return vnumber;
    }

    public void setVnumber(Integer vnumber) {
        this.vnumber = vnumber;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public  SchollVacancy(){

    }




    @Override
    public String toString() {
        return "SchollVacancy{" +
                "id=" + id +
                ", schollId='" + schollId + '\'' +
                ", contacts='" + contacts + '\'' +
                ", subName='" + subName + '\'' +
                ", vnumber=" + vnumber +
                ", delFlag='" + delFlag + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}