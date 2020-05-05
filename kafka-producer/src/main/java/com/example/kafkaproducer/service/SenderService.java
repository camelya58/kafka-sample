package com.example.kafkaproducer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.awt.*;

@Slf4j
@Service
public class SenderService {

    @Value("${kafka-producer.topic}")
    private String kafkaTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload){
        log.info("Sending message = '{}'", payload);
        kafkaTemplate.send(kafkaTopic, payload);
    }
}
