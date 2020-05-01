package com.itheima.paging;

import com.itheima.domian.SysLog;

import java.util.List;


public class LogPage {
    Integer code=0;
    String msg="";
    Integer count=0;
    List<SysLog> data;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<SysLog> getData() {
        return data;
    }

    public void setData(List<SysLog> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LogPage{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
