package com.itransition.rabbitconsumer.printer;

import com.itransition.rabbitconsumer.consumer.Consumer;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class SignUpMessagePrinter {
    private final Consumer consumer;

    @Autowired
    public SignUpMessagePrinter(Consumer consumer) {
        this.consumer = consumer;
    }

    @RabbitListener(queues = "messageBrokerQueue")
    public void listen() throws IOException, TimeoutException {
        String get = consumer.get();
        System.out.printf(get);
    }
}
