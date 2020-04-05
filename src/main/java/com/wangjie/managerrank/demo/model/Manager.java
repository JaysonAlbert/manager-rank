package com.wangjie.managerrank.demo.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Manager implements Serializable
{
    @Id
    private String id;

    private String url;
    private String name;
    private String appointment_date;
    private String introduction;
    private String company;
    private String fund_asset_size;
    private String sex;
    private List<Map> picture;
    private List<String> image_urls;
    private String funds;
    private String best_return;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(List<String> image_urls) {
        this.image_urls = image_urls;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFund_asset_size() {
        return fund_asset_size;
    }

    public void setFund_asset_size(String fund_asset_size) {
        this.fund_asset_size = fund_asset_size;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Map> getPicture() {
        return picture;
    }

    public void setPicture(List<Map> picture) {
        this.picture = picture;
    }

    public String getFunds() {
        return funds;
    }

    public void setFunds(String funds) {
        this.funds = funds;
    }

    public String getBest_return() {
        return best_return;
    }

    public void setBest_return(String best_return) {
        this.best_return = best_return;
    }
}
