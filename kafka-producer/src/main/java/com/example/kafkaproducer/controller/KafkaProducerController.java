package com.example.kafkaproducer.controller;

import com.example.kafkaproducer.service.SenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
@AllArgsConstructor
@Api(value = "/kafka", produces = "application/json")
public class KafkaProducerController {

    @Autowired
    private SenderService senderService;

    @ApiOperation(value = "Send message to Kafka")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Message delivered"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Entry not found")
    })
    @PostMapping(value = "/publish")
    public void send(@RequestParam String message){
        senderService.send(message);
    }

}
