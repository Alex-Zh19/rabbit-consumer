package com.itransition.rabbitconsumer.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class RabbitConsumerMessageDto {
   private String message;
}
