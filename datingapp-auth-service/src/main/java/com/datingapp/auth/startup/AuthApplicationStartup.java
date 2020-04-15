package com.datingapp.auth.startup;

import com.datingapp.auth.data.common.EnumUserGender;
import com.datingapp.auth.data.common.EnumUserRole;
import com.datingapp.auth.data.dto.UserDto;
import com.datingapp.auth.data.common.UserPreference;
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

        UserDto user1 = new UserDto("volkan", "12345", EnumUserRole.USER);
        user1.setUserPreference(new UserPreference(1, 1, 1, EnumUserGender.FEMALE));
        userService.saveUser(user1);

        UserDto user2 = new UserDto("onurcan", "12345", EnumUserRole.USER);
        user2.setUserPreference(new UserPreference(1, 1, 1, EnumUserGender.FEMALE));
        userService.saveUser(user2);

        UserDto user3 = new UserDto("admin", "admin", EnumUserRole.ADMIN);

        userService.saveUser(user3);
    }
}
