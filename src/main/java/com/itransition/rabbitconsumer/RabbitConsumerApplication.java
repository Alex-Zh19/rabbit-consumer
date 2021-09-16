package com.itransition.rabbitconsumer;

import com.itransition.rabbitconsumer.consumer.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitConsumerApplication.class, args);
        Consumer consumer=new Consumer();
        consumer.get();
    }

}
