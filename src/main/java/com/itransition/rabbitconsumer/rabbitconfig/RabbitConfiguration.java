package com.itransition.rabbitconsumer.rabbitconfig;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitConfiguration {

    @Value("${rabbit.host}")
    private String HOST;
    @Value("${rabbit.queue}")
    private String QUEUE_NAME;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory(HOST);
        return connectionFactory;
    }

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME);
    }
}
