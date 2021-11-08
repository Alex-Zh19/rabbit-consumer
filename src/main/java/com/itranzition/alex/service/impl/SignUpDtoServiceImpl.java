package com.itranzition.alex.service.impl;

import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import com.itranzition.alex.repository.RedisRepository;
import com.itranzition.alex.service.SignUpDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpDtoServiceImpl implements SignUpDtoService {
    private final RedisRepository repository;


    @Override
    public void addSignUpLog(RabbitConsumerMessageDto dto) {
        String email = dto.getRegisteredUser().getEmail();
        repository.save(email, dto);
    }

    @Override
    public RabbitConsumerMessageDto findSignUpLogByEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new RuntimeException("email cannot be null or empty");
        }
        return repository.findByEmail(email);
    }
}
