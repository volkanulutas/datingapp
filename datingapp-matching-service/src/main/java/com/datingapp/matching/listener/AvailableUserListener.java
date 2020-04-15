package com.datingapp.matching.listener;

import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.service.AvailableUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Slf4j
@Component
public class AvailableUserListener {
    @Autowired
    private AvailableUserService availableUserService;

    @RabbitListener(bindings =
    @QueueBinding(value = @Queue(value = "${amqp.availableuser.queuename}", durable = "true"),
            exchange = @Exchange(value = "${amqp.availableuser.exchange}"),
            key = "${amqp.availableuser.routingkey}"))
    public void handle(AvailableUserDto dto) {
        log.info("AvailableUser... -> " + dto.toString());
        availableUserService.save(dto);
    }
}


