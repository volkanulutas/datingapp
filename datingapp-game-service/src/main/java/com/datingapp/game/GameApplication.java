package com.datingapp.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Datingapp on 19.03.2020
 *
 * @author volkanulutas
 */
@SpringBootApplication
@EnableFeignClients
public class GameApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }
}
