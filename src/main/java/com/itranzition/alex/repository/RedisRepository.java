package com.itranzition.alex.repository;

import com.itranzition.alex.dto.RabbitConsumerMessageDto;
import com.itranzition.alex.util.RedisIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRepository {
    private final RedisTemplate<Long, RabbitConsumerMessageDto> redisTemplate;

    public void save(RabbitConsumerMessageDto messageDto) {
        redisTemplate.opsForValue().set(RedisIdGenerator.getRedisId(), messageDto);
    }

    public RabbitConsumerMessageDto findById(long id) {
        return redisTemplate.opsForValue().get(id);
    }
}
