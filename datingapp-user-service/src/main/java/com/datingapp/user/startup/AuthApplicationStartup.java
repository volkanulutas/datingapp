package com.datingapp.user.startup;

import com.datingapp.user.data.common.EnumUserGender;
import com.datingapp.user.data.common.EnumUserRole;
import com.datingapp.user.data.dto.UserDto;
import com.datingapp.user.data.dto.UserPreferenceDto;
import com.datingapp.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthApplicationStartup {

    @Autowired
    private UserService userService;

    @EventListener
    public void applicationInitialized(ApplicationReadyEvent event) {

        UserDto user1 = new UserDto("volkan", "12345", EnumUserRole.USER);
        user1.setUserPreference(new UserPreferenceDto(1, 1, 1, EnumUserGender.FEMALE));
        userService.saveUser(user1);

        UserDto user2 = new UserDto("onurcan", "12345", EnumUserRole.USER);
        user2.setUserPreference(new UserPreferenceDto(1, 1, 1, EnumUserGender.FEMALE));
        userService.saveUser(user2);

        UserDto user3 = new UserDto("admin", "admin", EnumUserRole.ADMIN);

        userService.saveUser(user3);
    }
}
