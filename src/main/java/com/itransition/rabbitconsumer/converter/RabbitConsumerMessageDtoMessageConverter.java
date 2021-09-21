package com.itransition.rabbitconsumer.converter;

import com.itransition.rabbitconsumer.dto.RabbitConsumerMessageDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.nio.charset.StandardCharsets;

public class RabbitConsumerMessageDtoMessageConverter extends AbstractMessageConverter {
    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        RabbitConsumerMessageDto messageDto = (RabbitConsumerMessageDto) o;
        Message message = new Message(messageDto.getMessage().getBytes(StandardCharsets.UTF_8));
        return message;
    }

    @Override
    public RabbitConsumerMessageDto fromMessage(Message message) throws MessageConversionException {
        String messageBody = new String(message.getBody(), StandardCharsets.UTF_8);
        RabbitConsumerMessageDto messageDto = new RabbitConsumerMessageDto(messageBody);
        return messageDto;
    }
}
