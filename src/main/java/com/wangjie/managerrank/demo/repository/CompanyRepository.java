package com.wangjie.managerrank.demo.repository;

import com.wangjie.managerrank.demo.model.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "company", path = "company")
public interface CompanyRepository extends MongoRepository<Company, String> {

    @RestResource(path="name")
    Company findByName(@Param("name") String name);
}
