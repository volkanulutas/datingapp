package com.datingapp.auth.controller;

import com.datingapp.auth.converter.AvailableUserConverter;
import com.datingapp.auth.data.common.EnumUserGender;
import com.datingapp.auth.data.dto.UserDto;
import com.datingapp.auth.data.dto.AvailableUserDto;
import com.datingapp.auth.data.entity.User;
import com.datingapp.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@RestController
public class UserController {

    @Autowired
    private AvailableUserConverter availableUserConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    // @RequestMapping("/")
    @GetMapping(value = "/")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of demo1 service running at different ports.
        // We load balance among them, and display which instance received the request.
        return "GET Hello from Auth Service running at port: " + env.getProperty("local.server.port");
    }

    /*
    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto userDTO) {
        UserDto user = userService.saveUser(userDTO).orElse(null);
        return (user == null) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/availableuser")
    public ResponseEntity<?> getAvailableUser() {
        List<User> userList = userService.getAvailableUser();
        List<AvailableUserDto> availableUserList = new ArrayList<>();
        for (User appUser : userList) {
            AvailableUserDto availableUserDto = availableUserConverter.toDto(appUser);
            availableUserList.add(availableUserDto);
        }
        return (availableUserList.isEmpty()) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) :
                new ResponseEntity<>(availableUserList, HttpStatus.OK);
    }

    @GetMapping(value = "test1")
    public ResponseEntity<?> send() {
        AvailableUserDto test1 = new AvailableUserDto();
        test1.setName("volkan");
        test1.setBirthDate(1);
        test1.setBirthPlace("Kayseri");
        test1.setGender(EnumUserGender.MALE);
        test1.setId("1");
        test1.setSurname("Ulutas");
        test1.setUsername("volkanulutas");
        userService.sendAvailableUser(test1);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     */
}