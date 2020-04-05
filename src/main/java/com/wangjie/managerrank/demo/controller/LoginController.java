package com.wangjie.managerrank.demo.controller;

import com.wangjie.managerrank.demo.model.*;
import com.wangjie.managerrank.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UserService userService){
        this.userService = userService;
    }

    private UserService userService;

    @PostMapping(value = "/login")
    public Response<UserSession> login(@RequestBody Login login){
        logger.info(String.format("login: %s", login.getCode()));
        return userService.login(login.getCode());
    }

    @PostMapping(value = "/saveUser")
    public Response<String> saveUser(@RequestBody User user){
        String userId = userService.save(user);
        return Response.builder().succeed().build(userId);
    }

    @PostMapping(value = "/logout")
    public Response<String> logout(@RequestBody Logout logout){
        logger.info(String.format("logout: %s",logout.getOpenid()));
        return Response.builder().succeed().build(userService.logout(logout.getOpenid()));
    }
}
