package com.itranzition.alex;

import com.itranzition.alex.properties.RabbitConfigurationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties({RabbitConfigurationProperties.class})
class RabbitConsumerApplicationTests {

    @Test
    void contextLoads() {
    }
}
