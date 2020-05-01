package com.itheima.paging;

import com.itheima.domian.SysUser;

import java.util.List;

public class UserPage {

    Integer code=0;
    String msg="";
    Integer count=0;
    List<SysUser> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public List<SysUser> getData() {
        return data;
    }

    public void setData(List<SysUser> data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserPage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
