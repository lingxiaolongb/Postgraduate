package com.itheima.paging;

import com.itheima.domian.StudentInfo;


import java.io.Serializable;
import java.util.List;

public class SsmPage implements Serializable {

    private List<StudentInfo> infos;
    private Page page;


    public List<StudentInfo> getInfos() {
        return infos;
    }

    public void setInfos(List<StudentInfo> infos) {
        this.infos = infos;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "SsmPage{" +
                "infos=" + infos +
                ", page=" + page +
                '}';
    }
}
