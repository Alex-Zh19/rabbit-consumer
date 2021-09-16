package com.itransition.rabbitconsumer.consumer;

import com.itransition.rabbitconsumer.rabbitconfig.RabbitConfiguration;
import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
/*
@Component
public class Consumer {
    private final RabbitTemplate rabbitTemplate;
    private final Consumer consumer;
    private final String exchange = "exchangeForQueue";
    private final String ROUTING_KEY = "rrrrrrrrrrouting";

    public Runner(Consumer consumer, RabbitTemplate rabbitTemplate) {
        this.consumer = consumer;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(exchange, ROUTING_KEY, "Hello from RabbitMQ!");
        consumer.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }


}*/
