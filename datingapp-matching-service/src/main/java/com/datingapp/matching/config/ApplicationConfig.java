package com.datingapp.matching.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 11.04.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@Configuration
@PropertySource("classpath:application.yml")
public class ApplicationConfig {

    @Value("${amqp.availableuser.exchange}")
    private String availableMatchQueueExchange;

    @Value("${amqp.availableuser.routingkey}")
    private String availableMatchQueueRoutingKey;

    @Value("${amqp.availableuser.queuename}")
    private String availableMatchQueueQueueName;
}
