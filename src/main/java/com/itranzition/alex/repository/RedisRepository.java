package com.itranzition.alex.repository;

import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRepository {
    private final RedisTemplate<String, RabbitConsumerMessageDto> redisTemplate;

    public void save(String keyEmail, RabbitConsumerMessageDto messageDto) {
        redisTemplate.opsForValue().set(keyEmail, messageDto);
    }

    public RabbitConsumerMessageDto findByEmail(String email) {
        return redisTemplate.opsForValue().get(email);
    }
}
