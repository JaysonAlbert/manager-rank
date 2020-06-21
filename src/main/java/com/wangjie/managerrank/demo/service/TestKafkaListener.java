package com.wangjie.managerrank.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TestKafkaListener {

    private Logger logger = LoggerFactory.getLogger(TestKafkaListener.class);

    @KafkaListener(topics = "test4")
    public void processMessage(String content) {
        Set<Character> s = new HashSet<>();
        logger.warn(content);
    }
}
