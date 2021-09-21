package com.itransition.rabbitconsumer.printer;

import com.itransition.rabbitconsumer.dto.RabbitConsumerMessageDto;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SignUpMessagePrinter {

    private static final Logger logger = LogManager.getLogger();

    @RabbitListener(queues = "${rabbit.queue}",messageConverter = "messageConverter")
    public void worker1(RabbitConsumerMessageDto messageDto) {
        logger.log(Level.INFO, messageDto.toString());
    }
}
