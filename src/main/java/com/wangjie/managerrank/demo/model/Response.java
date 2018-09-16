package com.wangjie.managerrank.demo.model;

public class Response<T> {
    private String code;
    private String errorMsg;
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Response<T> succeed(){
        code = "0000";
        return this;
    }

    public Response<T> failed(){
        code = "9999";
        return this;
    }

    public Response<T> failed(String code, String errorMsg){
        this.code = code;
        this.errorMsg = errorMsg;
        return this;
    }
}
