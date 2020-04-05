package com.wangjie.managerrank.demo.service;

import com.wangjie.managerrank.demo.model.Manager;
import com.wangjie.managerrank.demo.repository.ManagerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ManagerService {

    private ManagerRepository managerRepository;

    static final String CACHE_MANAGERS = "cache.managers";

    static final String CACHE_MANAGER = "cache.manager";

    static final String CACHE_MANAGER_NAMES = "cache.manager.names";

    public ManagerService(ManagerRepository managerRepository){
        this.managerRepository = managerRepository;
    }

    @Cacheable(CACHE_MANAGERS)
    public Manager[] findAll(){
        return managerRepository.findAll().toArray(new Manager[0]);
    }

    @Cacheable(cacheNames = CACHE_MANAGER, key="#name")
    public Manager[] findByName(String name){
        return managerRepository.findByName(name).toArray(new Manager[0]);
    }

    @Cacheable(CACHE_MANAGER_NAMES)
    public String[] findAllNames(){
        return Stream.of(findAll()).map(Manager::getName).distinct().toArray(String[]::new);
    }

}
