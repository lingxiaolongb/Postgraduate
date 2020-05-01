package com.itheima.domian;

import java.io.Serializable;

public class SysUserRole  implements Serializable {

    private Long id;

    private String rname;

    private String loginName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "SysUserRole{" +
                "id=" + id +
                ", rname='" + rname + '\'' +
                ", loginName='" + loginName + '\'' +
                '}';
    }
}
