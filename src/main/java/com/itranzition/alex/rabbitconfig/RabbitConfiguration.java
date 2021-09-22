package com.itranzition.alex.rabbitconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
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

    @Bean(name = "factory")
    public SimpleRabbitListenerContainerFactory factory(ConnectionFactory connectionFactory,
                                                        MessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory = new SimpleRabbitListenerContainerFactory();
        rabbitListenerContainerFactory.setConnectionFactory(connectionFactory);
        rabbitListenerContainerFactory.setMessageConverter(messageConverter);
        return rabbitListenerContainerFactory;
    }

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME);
    }

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    @Bean
    public MessageConverter jsonToMapMessageConverter(ObjectMapper objectMapper) {
        Jackson2JsonMessageConverter messageConverter = new ImplicitJsonMessageConverter(objectMapper);
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setTrustedPackages("*");
        classMapper.setDefaultType(RabbitConsumerMessageDto.class);
        messageConverter.setClassMapper(classMapper);
        return messageConverter;
    }

    public static class ImplicitJsonMessageConverter extends Jackson2JsonMessageConverter {
        public ImplicitJsonMessageConverter(ObjectMapper jsonObjectMapper) {
            super(jsonObjectMapper, "*");
        }
        @Override
        public Object fromMessage(Message message) throws MessageConversionException {
            message.getMessageProperties().setContentType("application/json");
            return super.fromMessage(message);
        }
    }

    /*
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }*/
 /*@Bean
    MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }
*/
}
