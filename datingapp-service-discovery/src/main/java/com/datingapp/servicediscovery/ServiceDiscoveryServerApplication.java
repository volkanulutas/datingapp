package com.datingapp.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryServerApplication.class, args);
	}
}
