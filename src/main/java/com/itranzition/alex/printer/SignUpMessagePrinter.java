package com.itranzition.alex.printer;

import com.itranzition.alex.dto.RabbitConsumerMessageDto;
import com.itranzition.alex.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpMessagePrinter {
    private final RedisRepository repository;
    private static final Logger logger = LogManager.getLogger();

    @RabbitListener(queues = "${rabbit.queue}")
    public void worker1(RabbitConsumerMessageDto messageDto) {
        logger.log(Level.INFO, messageDto.toString());
        repository.save(messageDto);
    }
}
