package com.itransition.rabbitconsumer.printer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SignUpMessagePrinter {
    @RabbitListener(queues = "messageBrokerQueue")
    public void worker1(String message) {
        System.out.println(message);
    }
}
