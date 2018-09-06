package com.wangjie.managerrank.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "manager", path = "manager")
public interface ManagerRepository extends MongoRepository<Manager, String> {
}
