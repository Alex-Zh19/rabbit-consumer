package com.itransition.rabbitconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class RabbitConsumerMessageDto implements Serializable {
   private final String message;
}
