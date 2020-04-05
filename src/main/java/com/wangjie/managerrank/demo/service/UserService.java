package com.wangjie.managerrank.demo.service;

import com.wangjie.managerrank.demo.model.Response;
import com.wangjie.managerrank.demo.model.User;
import com.wangjie.managerrank.demo.model.UserSession;
import com.wangjie.managerrank.demo.repository.UserRepository;
import com.wangjie.managerrank.demo.repository.UserSessionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(MiniProgramService miniProgramService, UserSessionRepository userSessionRepository, UserRepository userRepository){
        this.miniProgramService = miniProgramService;
        this.userRepository = userRepository;
        this.userSessionRepository = userSessionRepository;
    }

    private MiniProgramService miniProgramService;

    private UserSessionRepository userSessionRepository;

    private UserRepository userRepository;

    public Response<UserSession> login(String code){
        UserSession userSession = miniProgramService.login(code);

        if(null == userSession){
            log.error("小程序登陆失败");
            return Response.builder().failed().msg("小程序登录失败").build(null);
        }

        userSession.setLoginDate(new Date());

        UserSession savedSession = userSessionRepository.findByOpenid(userSession.getOpenid());
        if(null == savedSession){
            log.info("session不存在，保存session");
            userSessionRepository.save(userSession);
        }

        log.info("登陆成功， session： " + userSession.toString());

        return Response.builder().succeed().build(userSession);
    }

    public String save(User user){
        userRepository.save(user);
        return user.getId();
    }

    public String logout(String openid){
        return openid;
    }
}
