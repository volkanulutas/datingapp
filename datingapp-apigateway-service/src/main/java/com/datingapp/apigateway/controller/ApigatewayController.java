package com.datingapp.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@RestController
public class ApigatewayController {

    @Autowired
    private Environment env;

    @GetMapping(value = "/")
    public String home() {
        return "datingapp-apigateway-service running at port: " + env.getProperty("local.server.port");
    }
}