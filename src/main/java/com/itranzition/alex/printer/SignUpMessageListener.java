package com.itranzition.alex.printer;

import com.itranzition.alex.model.MessagePrinter;
import com.itranzition.alex.model.dto.RabbitConsumerMessageDto;
import com.itranzition.alex.service.SignUpDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpMessageListener {
    private final SignUpDtoService service;
    private final MessagePrinter printer;

    @RabbitListener(queues = "${rabbit.queue}")
    public void rabbitListener(RabbitConsumerMessageDto messageDto) {
        printer.print(messageDto);
        service.addSignUpLog(messageDto);
    }
}
