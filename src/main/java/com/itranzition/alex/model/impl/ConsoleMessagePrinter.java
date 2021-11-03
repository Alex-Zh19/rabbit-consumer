package com.itranzition.alex.model.impl;

import com.itranzition.alex.model.MessagePrinter;
import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMessagePrinter implements MessagePrinter {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void print(RabbitConsumerMessageDto dto) {
        logger.log(Level.INFO, dto.toString());
    }
}
