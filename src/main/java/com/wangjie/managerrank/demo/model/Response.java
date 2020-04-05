package com.wangjie.managerrank.demo.model;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private String code;
    private String errorMsg;
    private T data;

    public static Builder builder(){
        return new Builder();
    }

   public static class Builder{
        String code;
        String errorMsg;

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public Builder msg(String errorMsg){
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder succeed(){
            code = "0000";
            return this;
        }

        public Builder failed(){
            code = "9999";
            return this;
        }

        public <T> Response<T> build(T data){
            Response<T> response = new Response<>();
            response.code = code;
            response.errorMsg = errorMsg;
            response.data = data;
            return response;
        }
    }

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
}
