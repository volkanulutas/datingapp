package com.datingapp.matching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients

public class MatchingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchingServiceApplication.class, args);
	}
}