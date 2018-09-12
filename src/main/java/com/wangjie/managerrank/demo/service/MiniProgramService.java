package com.wangjie.managerrank.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangjie.managerrank.demo.controller.LoginController;
import com.wangjie.managerrank.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MiniProgramService {

    private Logger log = LoggerFactory.getLogger(MiniProgramService.class);

    @Value("${miniprogram.secret}")
    private String secret;

    @Value("${miniprogram.appid}")
    private String appid;

    @Value("${miniprogram.login-url}")
    private String loginUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    public User login(String code){
        String userResponse = restTemplate.getForObject(loginUrl, String.class,appid,secret,code);
        try{
            return objectMapper.readValue(userResponse,User.class);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;

    }
}
