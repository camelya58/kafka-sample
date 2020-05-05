package com.example.kafka.kafkaconsumer.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Data
public class ReceiverService {

    private CountDownLatch latch = new CountDownLatch(1);


    public CountDownLatch getLatch(){
        return latch;
    }

    @KafkaListener(topics = "${kafka-consumer.topic}")
    public void receiveAndSave(String payload){
        log.info("Receive message= '{}' ", payload);

        latch.countDown();
    }
}
