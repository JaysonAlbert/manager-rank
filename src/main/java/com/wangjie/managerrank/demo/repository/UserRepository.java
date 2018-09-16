package com.wangjie.managerrank.demo.repository;

import com.wangjie.managerrank.demo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByOpenid(String openid);
}
