package com.spring_rabbitmq.rabbitmq_demo.controller;

import com.spring_rabbitmq.rabbitmq_demo.service.RabbitMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/producer")
public class ProducerController {
    @Autowired
    private RabbitMqProducer producer;
    @GetMapping("/send")
    public String sendMessage(@RequestParam String message){
        producer.send(message);
        return "message send successfully";
    }
    @GetMapping("/jsonMessage")
    public String sendMessage(@RequestBody Map<String,Object> jsonMessage){
        producer.send(jsonMessage);
        return "Json message send successfully";
    }
}
