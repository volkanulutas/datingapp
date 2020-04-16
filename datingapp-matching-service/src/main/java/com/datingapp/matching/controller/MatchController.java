package com.datingapp.matching.controller;

import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.dto.UserDto;
import com.datingapp.matching.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@RestController
public class MatchController {

    @Autowired
    private MatchingService matchingService;

    @Autowired
    private Environment env;

    @GetMapping(value = "/")
    public String home() {
        return "datingapp-matching-service running at port: " + env.getProperty("local.server.port");
    }

    @PostMapping(path = "/match", consumes = "application/json", produces = "application/json")
    public void matchUsers(@RequestBody UserDto userDto1, @RequestBody UserDto userDto2) {
        matchingService.matchUsers(userDto1, userDto1);
    }

    @GetMapping(value = "/matchList")
    public ResponseEntity<MatchUserDto> getPreMatchUsersByUserId(@RequestParam String userId) {
        MatchUserDto matchDto = matchingService.findMachingByUserId(userId);
        return new ResponseEntity(matchDto, HttpStatus.OK);
    }
}
