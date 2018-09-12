package com.wangjie.managerrank.demo.model;

public class User {
    private String session_key;
    private String openid;

    public String getSession_key() {
        return session_key;
    }

    public User setSession_key(String session_key) {
        this.session_key = session_key;
        return this;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
