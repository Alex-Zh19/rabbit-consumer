package com.itranzition.alex.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itranzition.alex.properties.RabbitConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableRabbit
@Configuration
@RequiredArgsConstructor
public class RabbitConfiguration {
    private final RabbitConfigurationProperties properties;

    @Bean
    public Queue myQueue() {
        return new Queue(properties.getQueue());
    }

    @Bean
    public MessageConverter jsonToMapMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
