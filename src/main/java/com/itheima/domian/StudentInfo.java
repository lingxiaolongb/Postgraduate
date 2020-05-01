package com.itheima.domian;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    private String examId;

    private String sname;

    private String fromSchool;

    private String fromSubject;

    private String toSchool;

    private String toSubject;

    private Integer total;

    private Integer politics;

    private Integer english;

    private Integer math;

    private Integer specialized;

    private String delFlag;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId == null ? null : examId.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getFromSchool() {
        return fromSchool;
    }

    public void setFromSchool(String fromSchool) {
        this.fromSchool = fromSchool == null ? null : fromSchool.trim();
    }

    public String getFromSubject() {
        return fromSubject;
    }

    public void setFromSubject(String fromSubject) {
        this.fromSubject = fromSubject == null ? null : fromSubject.trim();
    }

    public String getToSchool() {
        return toSchool;
    }

    public void setToSchool(String toSchool) {
        this.toSchool = toSchool == null ? null : toSchool.trim();
    }

    public String getToSubject() {
        return toSubject;
    }

    public void setToSubject(String toSubject) {
        this.toSubject = toSubject == null ? null : toSubject.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPolitics() {
        return politics;
    }

    public void setPolitics(Integer politics) {
        this.politics = politics;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getSpecialized() {
        return specialized;
    }

    public void setSpecialized(Integer specialized) {
        this.specialized = specialized;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "examId='" + examId + '\'' +
                ", sname='" + sname + '\'' +
                ", fromSchool='" + fromSchool + '\'' +
                ", fromSubject='" + fromSubject + '\'' +
                ", toSchool='" + toSchool + '\'' +
                ", toSubject='" + toSubject + '\'' +
                ", total=" + total +
                ", politics=" + politics +
                ", english=" + english +
                ", math=" + math +
                ", specialized=" + specialized +
                ", delFlag='" + delFlag + '\'' +
                '}';
    }
}