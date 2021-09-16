package com.itransition.rabbitconsumer.consumer;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Consumer {

    private final String QUEUE_NAME = "messageBrokerQueue";

    public void get() {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicConsume(QUEUE_NAME, true, (consumerTag, message) -> {
                        String m = new String(message.getBody(), "UTF-8");
                        System.out.println("message is: " + m);
                    },
                    consumerTage -> {
                    });
        } catch (TimeoutException | IOException e) {
            System.out.println(e);
        }
    }

}
