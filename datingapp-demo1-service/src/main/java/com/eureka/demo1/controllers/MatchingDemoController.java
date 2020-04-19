package com.eureka.demo1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchingDemoController {

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "Hello from Demo1 Service running at port: " + env.getProperty("local.server.port");
    }
}
