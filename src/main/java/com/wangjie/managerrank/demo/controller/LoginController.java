package com.wangjie.managerrank.demo.controller;

import com.wangjie.managerrank.demo.model.*;
import com.wangjie.managerrank.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public Response<UserSession> login(@RequestBody Login login){
        return userService.login(login.getCode());
    }

    @PostMapping(value = "/saveUser")
    public Response<String> saveUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping(value = "/logout")
    public Response<String> logout(@RequestBody Logout logout){
        return null;
    }
}
