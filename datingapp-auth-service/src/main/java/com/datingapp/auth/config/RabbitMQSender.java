package com.datingapp.auth.config;

import com.datingapp.auth.data.dto.BaseDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String exchange, String routingkey, BaseDto baseDto) {
        amqpTemplate.convertAndSend(exchange, routingkey, baseDto);
        System.out.println("Send msg = " + baseDto);
    }
}
