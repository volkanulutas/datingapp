package com.eureka.demo1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Demo1Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo1Controller.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment env;


    @GetMapping(value = "/")
    public String home() {
        return "datingapp-demo1-service running at port: " + env.getProperty("local.server.port");
    }

    // @RequestMapping("/")
    @PostMapping(path = "/post", produces = "application/json")
    public String home2() {
        // This is useful for debugging
        // When having multiple instance of demo1 service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "POST Hello from Demo1 Service running at port: " + env.getProperty("local.server.port");
    }

    // -------- Admin Area --------
    // This method should only be accessed by users with role of 'admin'
    // We'll add the logic of role based auth later
    @RequestMapping("/admin")
    public String homeAdmin() {
        return "This is the admin area of Demo1 service running at port: " + env.getProperty("local.server.port");
    }
}