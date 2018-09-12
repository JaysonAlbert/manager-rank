package com.wangjie.managerrank.demo.controller;

import com.wangjie.managerrank.demo.model.User;
import com.wangjie.managerrank.demo.model.Login;
import com.wangjie.managerrank.demo.service.MiniProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    MiniProgramService miniProgramService;

    @PostMapping(value = "/login")
    public User login(@RequestBody Login login){
        return miniProgramService.login(login.getCode());
    }
}
