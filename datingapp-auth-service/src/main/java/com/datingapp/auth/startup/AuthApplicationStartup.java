package com.datingapp.auth.startup;

import com.datingapp.auth.data.common.EnumUserRole;
import com.datingapp.auth.data.entity.AppUser;

import com.datingapp.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Component
public class AuthApplicationStartup {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthApplicationStartup.class);

    @Autowired
    private UserService userService;

    @EventListener
    public void applicationInitialized(ApplicationReadyEvent event) {
        userService.createUser(new AppUser("volkan", "12345", EnumUserRole.USER));
        userService.createUser(new AppUser("onurcan", "12345", EnumUserRole.USER));
        userService.createUser(new AppUser("admin", "12345", EnumUserRole.ADMIN));
    }
}