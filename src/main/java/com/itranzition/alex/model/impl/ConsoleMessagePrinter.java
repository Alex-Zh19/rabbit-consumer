package com.itranzition.alex.model.impl;

import com.itranzition.alex.model.MessagePrinter;
import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ConsoleMessagePrinter implements MessagePrinter {

    @Override
    public void print(RabbitConsumerMessageDto dto) {
        log.info("{}", dto);
    }
}
