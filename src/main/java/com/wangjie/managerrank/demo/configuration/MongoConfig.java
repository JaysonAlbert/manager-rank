package com.wangjie.managerrank.demo.configuration;


import com.wangjie.managerrank.demo.model.User;
import com.wangjie.managerrank.demo.model.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;

@Configuration
public class MongoConfig {

    public MongoConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    private MongoTemplate mongoTemplate;


    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        IndexOperations indexOps = mongoTemplate.indexOps(UserSession.class);
        indexOps.ensureIndex(new Index().on("loginDate", Sort.Direction.ASC));
    }
}
