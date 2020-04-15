package com.datingapp.matching.config;

import com.datingapp.matching.data.dto.BaseDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, BaseDto dto) {
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }
}
