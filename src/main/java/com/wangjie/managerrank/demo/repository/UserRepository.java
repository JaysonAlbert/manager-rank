package com.wangjie.managerrank.demo.repository;

import com.wangjie.managerrank.demo.model.Login;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Login, String> {
}
