package com.wangjie.managerrank.demo.repository;

import com.wangjie.managerrank.demo.model.UserSession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserSessionRepository extends MongoRepository<UserSession, String> {
    UserSession findByOpenid(String openid);
}
