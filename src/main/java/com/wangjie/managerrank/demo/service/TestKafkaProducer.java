package com.wangjie.managerrank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;

@Service
public class TestKafkaProducer {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public TestKafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMsg(String topic, String key, String msg) throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult> rt =  kafkaTemplate.send(topic, key, msg);
        rt.get();
    }
}
