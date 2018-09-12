package com.wangjie.managerrank.demo.repository;

import com.wangjie.managerrank.demo.model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "manager", path = "manager")
public interface ManagerRepository extends MongoRepository<Manager, String> {
}
