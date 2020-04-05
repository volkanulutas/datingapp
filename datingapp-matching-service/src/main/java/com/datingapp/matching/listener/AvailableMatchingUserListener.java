package com.datingapp.matching.listener;

import com.datingapp.matching.data.dto.authservice.AvailableMatchingUserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AvailableMatchingUserListener {
    private static final Logger LOGGER = LogManager.getLogger(AvailableMatchingUserListener.class);

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "test1", durable = "false"),
            exchange = @Exchange(value = "test1"),
            key = "test1"))
    public void handle(AvailableMatchingUserDto dto) {

        System.out.println("");
    }
}


