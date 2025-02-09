package com.spring_rabbitmq.rabbitmq_demo.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMqProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    private AmqpTemplate amqpTemplate;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;
    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    public void send(String message){
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
        System.out.println("message send from producer : - "+message);
    }
    public void send(Map<String,Object>jsonMessage){
        System.out.println("json message send from producer : - "+jsonMessage);
        rabbitTemplate.convertAndSend(exchange,routingJsonKey,jsonMessage);
    }
}
