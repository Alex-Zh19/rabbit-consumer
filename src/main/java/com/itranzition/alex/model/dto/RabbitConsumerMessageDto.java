package com.itranzition.alex.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitConsumerMessageDto implements Serializable {
    private RegisteredUserDto registeredUser;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime signUpTime;
}
