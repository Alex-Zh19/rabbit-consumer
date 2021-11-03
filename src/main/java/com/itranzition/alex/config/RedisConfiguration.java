package com.itranzition.alex.config;

import com.itranzition.alex.dto.RabbitConsumerMessageDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<Long, RabbitConsumerMessageDto> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, RabbitConsumerMessageDto> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
}
