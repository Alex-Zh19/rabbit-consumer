package com.itransition.rabbitconsumer.rabbitconfig;


import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableRabbit
public class RabbitConfiguration {

    @Bean
    public ConnectionFactory myRabbitListenerContainerFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        return factory;
    }
}
