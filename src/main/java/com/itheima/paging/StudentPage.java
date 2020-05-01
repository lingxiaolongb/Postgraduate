package com.itheima.paging;

import com.itheima.domian.StudentInfo;

import java.io.Serializable;
import java.util.List;

public class StudentPage implements Serializable {
    Page page;

    List<StudentInfo> studentInfos;


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(List<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }

    @Override
    public String toString() {
        return "StudentPage{" +
                "page=" + page +
                ", studentInfos=" + studentInfos +
                '}';
    }
}
