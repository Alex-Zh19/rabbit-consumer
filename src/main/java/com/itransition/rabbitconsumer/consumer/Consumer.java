package com.itransition.rabbitconsumer.consumer;

import com.rabbitmq.client.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Component
public class Consumer {

    private final String QUEUE_NAME = "messageBrokerQueue";
    private String messageFromQueue = "default";

    public String get() throws TimeoutException, IOException {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            GetResponse response= channel.basicGet(QUEUE_NAME,true);
            String message= new String(response.getBody(),"UTF-8");
            /*channel.basicConsume(QUEUE_NAME, true, (consumerTag, message) -> {
                        String me = new String(message.getBody(), "UTF-8");
                        messageFromQueue = me;
                        System.out.println(me);
                        throw new RuntimeException("exeception blin");
                    },
                    consumerTage -> {
                        System.out.println("shhit");
                    });
        }*/
            return message;
        }
    }


}
