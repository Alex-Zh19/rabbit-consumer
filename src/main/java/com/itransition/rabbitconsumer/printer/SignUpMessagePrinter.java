package com.itransition.rabbitconsumer.printer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class SignUpMessagePrinter {

    private final RabbitTemplate template;
    private final String ROUTING_KEY = "rrrrrrrrrrouting";

    @Autowired
    public SignUpMessagePrinter(RabbitTemplate template) {
        this.template = template;
    }

    @RabbitListener(queues = "messageBrokerQueue")
    public void worker1(String message) {
     /*   Message me = template.receive();
        System.out.println(new String(me.getBody(), "UTF-8") + "    hurrey");*/
        System.out.println(message+" hurrey");
    }


}
