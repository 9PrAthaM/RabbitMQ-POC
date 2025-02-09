package com.spring_rabbitmq.rabbitmq_demo.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitMqConsumer {
    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message){
        System.out.println("consumed message:- "+message);
    }
    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeJson(Map<String,Object> map){
        System.out.println("consumed message:- "+map.toString());
    }
}
