package com.itheima.domian;

import java.io.Serializable;

public class SchollStudentMessage implements Serializable {
    private Long id;

    private String examId;

    private String schollId;

    private String subName;

    private String sendFlag;

    private String acceptFlag;

    private String delFlag;

    private String toName;


    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

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

    public String getSchollId() {
        return schollId;
    }

    public void setSchollId(String schollId) {
        this.schollId = schollId == null ? null : schollId.trim();
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag == null ? null : sendFlag.trim();
    }

    public String getAcceptFlag() {
        return acceptFlag;
    }

    public void setAcceptFlag(String acceptFlag) {
        this.acceptFlag = acceptFlag == null ? null : acceptFlag.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    @Override
    public String toString() {
        return "SchollStudentMessage{" +
                "id=" + id +
                ", examId='" + examId + '\'' +
                ", schollId='" + schollId + '\'' +
                ", subName='" + subName + '\'' +
                ", sendFlag='" + sendFlag + '\'' +
                ", acceptFlag='" + acceptFlag + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", toName='" + toName + '\'' +
                '}';
    }
}