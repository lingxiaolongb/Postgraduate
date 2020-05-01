package com.itheima.domian;

import java.io.Serializable;

public class StudentApplication implements Serializable {
    private Long id;

    private String examId;

    private String application1;

    private String flag1;

    private String application2;

    private String flag2;

    private String application3;

    private String flag3;

    private String application4;

    private String flag4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public String getApplication1() {
        return application1;
    }

    public void setApplication1(String application1) {
        this.application1 = application1 == null ? null : application1.trim();
    }

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1 == null ? null : flag1.trim();
    }

    public String getApplication2() {
        return application2;
    }

    public void setApplication2(String application2) {
        this.application2 = application2 == null ? null : application2.trim();
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2 == null ? null : flag2.trim();
    }

    public String getApplication3() {
        return application3;
    }

    public void setApplication3(String application3) {
        this.application3 = application3 == null ? null : application3.trim();
    }

    public String getFlag3() {
        return flag3;
    }

    public void setFlag3(String flag3) {
        this.flag3 = flag3 == null ? null : flag3.trim();
    }

    public String getApplication4() {
        return application4;
    }

    public void setApplication4(String application4) {
        this.application4 = application4 == null ? null : application4.trim();
    }

    public String getFlag4() {
        return flag4;
    }

    public void setFlag4(String flag4) {
        this.flag4 = flag4 == null ? null : flag4.trim();
    }

    @Override
    public String toString() {
        return "StudentApplication{" +
                "id=" + id +
                ", examId='" + examId + '\'' +
                ", application1='" + application1 + '\'' +
                ", flag1='" + flag1 + '\'' +
                ", application2='" + application2 + '\'' +
                ", flag2='" + flag2 + '\'' +
                ", application3='" + application3 + '\'' +
                ", flag3='" + flag3 + '\'' +
                ", application4='" + application4 + '\'' +
                ", flag4='" + flag4 + '\'' +
                '}';
    }
}