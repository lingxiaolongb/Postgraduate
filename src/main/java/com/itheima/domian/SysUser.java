package com.itheima.domian;

import java.io.Serializable;

public class SysUser implements Serializable {
    private Long id;

    private String loginName;

    private String password;

    private String uno;

    private String uname;

    private String email;

    private String uphone;

    private String loginFlag;

    private String delFlag;

    private String remarks;

    private SysUserRole userRole;

    public SysUserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(SysUserRole userRole) {
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno == null ? null : uno.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag == null ? null : loginFlag.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", uno='" + uno + '\'' +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", uphone='" + uphone + '\'' +
                ", loginFlag='" + loginFlag + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}