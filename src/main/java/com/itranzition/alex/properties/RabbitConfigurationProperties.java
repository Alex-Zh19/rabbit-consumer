package com.itranzition.alex.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "rabbit", ignoreUnknownFields = false)
public class RabbitConfigurationProperties {
    private String queue;
    @Value("${spring.rabbitmq.host}")
    private String host;
}
