package com.wangjie.managerrank.demo.repository;

import com.wangjie.managerrank.demo.model.Scale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "scale", path = "scale")
public interface FundScaleRepository extends MongoRepository<Scale, String> {

    @RestResource(path = "company")
    List<Scale> findByCompany(@Param("company") String company);
}
