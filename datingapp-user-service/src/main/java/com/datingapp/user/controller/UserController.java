package com.datingapp.user.controller;

import com.datingapp.user.converter.AvailableUserConverter;
import com.datingapp.user.converter.UserConverter;
import com.datingapp.user.data.dto.UserDto;
import com.datingapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private UserConverter userConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @GetMapping(value = "/")
    public String home() {
        return "datingapp-auth-service running at port: " + env.getProperty("local.server.port");
    }

    @RequestMapping(value = "/findUserByUsername", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserDto> findUserByUsername(@RequestParam String username) {
        UserDto userDto = userService.findUserByUsername(username);
        return (userDto == null) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UserDto> signup(@RequestBody UserDto userDto) {
        UserDto user = userService.saveUser(userDto).orElse(null);
        return (user == null) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public boolean deleteUser(@RequestParam String username) {
        return userService.deleteUser(username);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserDto>> list() {
        List<UserDto> allUser = userService.getAllUser();
        return (allUser.isEmpty()) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(allUser, HttpStatus.OK);
    }
}