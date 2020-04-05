package com.wangjie.managerrank.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class Company {
    @Id
    private String id;

    @Field()
    private String website;

    private String establishment_date;

    private String asset_size;

    private String phone;

    private String manager;

    private Integer fund_num;

    private String company_nature;

    private String short_name;

    private String url;

    private Integer manager_num;

    private String name;

    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEstablishment_date() {
        return establishment_date;
    }

    public void setEstablishment_date(String establishment_date) {
        this.establishment_date = establishment_date;
    }

    public String getAsset_size() {
        return asset_size;
    }

    public void setAsset_size(String asset_size) {
        this.asset_size = asset_size;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getFund_num() {
        return fund_num;
    }

    public void setFund_num(Integer fund_num) {
        this.fund_num = fund_num;
    }

    public String getCompany_nature() {
        return company_nature;
    }

    public void setCompany_nature(String company_nature) {
        this.company_nature = company_nature;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getManager_num() {
        return manager_num;
    }

    public void setManager_num(Integer manager_num) {
        this.manager_num = manager_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
