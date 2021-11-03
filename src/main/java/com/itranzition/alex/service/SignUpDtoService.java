package com.itranzition.alex.service;

import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;

public interface SignUpDtoService {
    void addSignUpLog(RabbitConsumerMessageDto dto);

    RabbitConsumerMessageDto findSignUpLogById(String email);
}
