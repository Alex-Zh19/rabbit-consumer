package com.itransition.rabbitconsumer.printer;

import com.itransition.rabbitconsumer.consumer.Consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpMessagePrinter {
    private final Consumer consumer;

    @Autowired
    public SignUpMessagePrinter(Consumer consumer) {
        this.consumer = consumer;
    }

    @RabbitListener
    public void listen(String in){
        System.out.printf(in);
    }
}
