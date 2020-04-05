package com.wangjie.managerrank.demo.controller;

import com.wangjie.managerrank.demo.model.Manager;
import com.wangjie.managerrank.demo.model.Response;
import com.wangjie.managerrank.demo.service.ManagerService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    public ManagerController(ManagerService managerService){
        this.managerService = managerService;
    }

    private ManagerService managerService;

    @GetMapping("/")
    Response<Manager[]> findAll(@RequestParam(required = false) Pageable pageable){
        return Response.builder().succeed().build(managerService.findAll());
    }

    @GetMapping("/search")
    Response<Manager[]> findByName(String name){
        return Response.builder().succeed().build(managerService.findByName(name));
    }

    @GetMapping("/names")
    Response<String[]> findAllNames(){
        return Response.builder().succeed().build(managerService.findAllNames());
    }
}
