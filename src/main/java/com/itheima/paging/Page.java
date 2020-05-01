package com.itheima.paging;

import java.io.Serializable;

public class Page implements Serializable {

    private Integer currentPage=1;
    private Integer pageSize=7;
    private Integer totalPage;//总页数
    private Integer rows; //数据总数
    private Integer begin;//起始下标

    public Integer getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage=currentPage==null?1:currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize==null?7:pageSize;
    }

    public Integer getTotalPage() {
        if(rows%pageSize==0){
            totalPage=rows/pageSize;
        }else {
            totalPage = rows / pageSize + 1;
        }
        return totalPage;

    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getBegin() {
        return (currentPage-1)*pageSize;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }



}
