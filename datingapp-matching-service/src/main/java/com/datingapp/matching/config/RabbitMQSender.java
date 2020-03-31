package com.datingapp.matching.config;

import com.datingapp.matching.data.dto.BaseDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String exchange, String routingkey, BaseDto dto) {
        rabbitTemplate.convertAndSend(exchange, routingkey, dto);
    }
}
