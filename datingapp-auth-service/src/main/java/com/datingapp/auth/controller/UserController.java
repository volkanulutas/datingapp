package com.datingapp.auth.controller;

import com.datingapp.auth.converter.AppUserConverter;
import com.datingapp.auth.data.dto.AppUserDto;
import com.datingapp.auth.data.entity.AppUser;
import com.datingapp.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private AppUserConverter appUserConverter;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AppUserDto> signup(@RequestBody AppUserDto userDTO) {
        AppUser appUser = appUserConverter.toEntity(userDTO);
        AppUser user = userService.createUser(appUser).orElse(null);
        return (user == null) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) : new ResponseEntity<>(appUserConverter.toDto(user), HttpStatus.OK);
    }
}