package com.datingapp.chat.listener;

import com.datingapp.chat.data.dto.MatchUserDto;
import com.datingapp.chat.service.ChatServiceImpl;
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
public class MatchUserListener {

    @Autowired
    private ChatServiceImpl chatService;

    @RabbitListener(bindings =
    @QueueBinding(value = @Queue(value = "${amqp.matcheduser.queuename}", durable = "true"),
            exchange = @Exchange(value = "${amqp.matcheduser.exchange}"),
            key = "${amqp.matcheduser.routingkey}"))
    public void handle(MatchUserDto dto) {
        log.info("MatchUserDto... -> " + dto.toString());

        chatService.handleMatchUser(dto);
        // availableUserService.save(dto);
    }
}


