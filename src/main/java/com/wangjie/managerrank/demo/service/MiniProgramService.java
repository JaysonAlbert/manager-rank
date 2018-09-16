package com.wangjie.managerrank.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangjie.managerrank.demo.model.UserSession;
import com.wangjie.managerrank.demo.model.User;
import com.wangjie.managerrank.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;


    public UserSession login(String code){
        String userResponse = restTemplate.getForObject(loginUrl, String.class,appid,secret,code);
        try{
            return objectMapper.readValue(userResponse,UserSession.class);
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
