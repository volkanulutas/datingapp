package com.datingapp.auth.controller;

import com.datingapp.auth.converter.MatchingUserConverter;
import com.datingapp.auth.converter.UserConverter;
import com.datingapp.auth.data.dto.matchingservice.AvailableMatchingUserDto;
import com.datingapp.auth.data.dto.AppUserDto;
import com.datingapp.auth.data.entity.AppUser;
import com.datingapp.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/")
public class UserController {

    @Autowired
    private MatchingUserConverter appUserMatchingConverter;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AppUserDto> signup(@RequestBody AppUserDto userDTO) {
        AppUserDto user = userService.createUser(userDTO).orElse(null);
        return (user == null) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getMatchingUser() {
        List<AppUser> userList = userService.getAvailableMatchingUser();
        List<AvailableMatchingUserDto> availableMatchingUserList = new ArrayList<>();
        for (AppUser appUser : userList) {
            AvailableMatchingUserDto appMatchingUserDto = appUserMatchingConverter.toDto(appUser);
            availableMatchingUserList.add(appMatchingUserDto);
        }
        return (availableMatchingUserList.isEmpty()) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) :
                new ResponseEntity<>(availableMatchingUserList, HttpStatus.OK);
    }

}