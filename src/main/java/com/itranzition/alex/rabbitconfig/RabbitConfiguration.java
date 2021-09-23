package com.itranzition.alex.rabbitconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@EnableRabbit
@Configuration
public class RabbitConfiguration {
    @Value("${rabbit.queue}")
    private String QUEUE_NAME;
    @Value("${spring.rabbitmq.host}")
    private String HOST;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(HOST);
    }

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }

    @Bean
    public MessageConverter jsonToMapMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
