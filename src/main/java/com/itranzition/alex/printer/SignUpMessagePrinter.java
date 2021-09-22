package com.itranzition.alex.printer;

import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SignUpMessagePrinter {

    private static final Logger logger = LogManager.getLogger();

    @RabbitListener(queues = "${rabbit.queue}",containerFactory = "factory")
    public void worker1(RabbitConsumerMessageDto messageDto) {
        logger.log(Level.INFO, messageDto.toString());
    }
}
