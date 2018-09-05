package com.wangjie.managerrank.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerRepository repository;

    @RequestMapping("/manager")
    public List<Manager> getManager(){
        return repository.findAll();
    }
}
