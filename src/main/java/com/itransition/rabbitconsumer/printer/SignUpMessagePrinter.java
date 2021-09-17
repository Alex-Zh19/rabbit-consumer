package com.itransition.rabbitconsumer.printer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SignUpMessagePrinter {

    private static final Logger logger = LogManager.getLogger();

    @RabbitListener(queues = "messageBrokerQueue")
    public void worker1(String message) {
        logger.log(Level.INFO, message);
    }
}
