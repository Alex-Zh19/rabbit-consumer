package com.itranzition.alex.model;

import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;

public interface MessagePrinter {
    void print(RabbitConsumerMessageDto dto);
}
