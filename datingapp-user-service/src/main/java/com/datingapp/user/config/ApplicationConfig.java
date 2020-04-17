package com.datingapp.user.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

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

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(64000);
        return loggingFilter;
    }

    @Value("${amqp.availableuser.exchange}")
    private String availableMatchQueueExchange;

    @Value("${amqp.availableuser.routingkey}")
    private String availableMatchQueueRoutingKey;
}
