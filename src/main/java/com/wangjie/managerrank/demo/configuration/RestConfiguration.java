package com.wangjie.managerrank.demo.configuration;

import com.wangjie.managerrank.demo.model.Company;
import com.wangjie.managerrank.demo.model.Manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.client.RestTemplate;


@Configuration
public class RestConfiguration extends RepositoryRestConfigurerAdapter {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
        config.exposeIdsFor(Company.class);
        config.exposeIdsFor(Manager.class);
    }
}
