package com.wangjie.managerrank.demo.controller;

import com.wangjie.managerrank.demo.model.Response;
import com.wangjie.managerrank.demo.service.TestKafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/msg")
@Slf4j
public class MsgController {

    private TestKafkaProducer testKafkaProducer;

    @Autowired
    public MsgController(TestKafkaProducer testKafkaProducer){
        this.testKafkaProducer = testKafkaProducer;
    }

    @PostMapping("/send")
    Response<Object> send(String topic, String key, String value){
        try {
            testKafkaProducer.sendMsg(topic, key, value);
        } catch (ExecutionException | InterruptedException e) {
            log.error("", e);
            return Response.builder().failed().msg(e.getMessage()).build(e.getMessage());
        }

        return Response.builder().succeed().build("");
    }
}
