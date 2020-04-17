package com.datingapp.matching.controller;

import com.datingapp.matching.data.dto.MatchUserDto;
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

    @PostMapping(path = "/match", produces = "application/json")
    public boolean matchUsers(@RequestParam String username1, @RequestParam String username2) {
        return matchingService.matchUsers(username1, username2);
    }

    @GetMapping(value = "/matchList", produces = "application/json")
    public ResponseEntity<MatchUserDto> getPreMatchUsersByUserId(@RequestParam String username) {
        MatchUserDto matchDto = matchingService.findMatchingByUsername(username);
        return new ResponseEntity(matchDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteMatch")
    public boolean deleteMatch(@RequestParam String username, @RequestParam String matchUsername) {
        return matchingService.deleteMatch(username, matchUsername);
    }
}
