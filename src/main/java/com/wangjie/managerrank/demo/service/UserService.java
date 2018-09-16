package com.wangjie.managerrank.demo.service;

import com.wangjie.managerrank.demo.controller.LoginController;
import com.wangjie.managerrank.demo.model.Response;
import com.wangjie.managerrank.demo.model.User;
import com.wangjie.managerrank.demo.model.UserSession;
import com.wangjie.managerrank.demo.repository.UserRepository;
import com.wangjie.managerrank.demo.repository.UserSessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Date;

@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private MiniProgramService miniProgramService;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @Autowired
    private UserRepository userRepository;

    public Response<UserSession> login(String code){
        Response<UserSession> res = new Response<>();
        UserSession userSession = miniProgramService.login(code);

        if(null == userSession){
            log.error("小程序登陆失败");
            return res.failed("9999","小程序登陆失败");
        }

        userSession.setLoginDate(new Date());

        UserSession savedSession = userSessionRepository.findByOpenid(userSession.getOpenid());
        if(null == savedSession){
            log.info("session不存在，保存session");
            userSessionRepository.save(userSession);
        }

        res.setData(userSession);

        log.info("登陆成功， session： " + userSession.toString());

        return res.succeed();
    }

    public Response<String> save(User user){
        userRepository.save(user);
        return new Response<String>().succeed();
    }

    public Response<String> logout(String openid){
        return new Response<String>().succeed();
    }
}
