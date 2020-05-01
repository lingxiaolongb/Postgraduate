package com.itheima.domian;



public class SysLog {

    private Long id;
    private String type;
    private String remoteAdd;
    private String method;
    private String url;
    private String exception;
    private String visitTime;
    private String operation;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemoteAdd() {
        return remoteAdd;
    }

    public void setRemoteAdd(String remoteAdd) {
        this.remoteAdd = remoteAdd;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", remoteAdd='" + remoteAdd + '\'' +
                ", method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", exception='" + exception + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
