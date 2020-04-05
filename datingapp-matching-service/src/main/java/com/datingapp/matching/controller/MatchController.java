package com.datingapp.matching.controller;

import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.dto.gameservice.UserDto;
import com.datingapp.matching.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MatchController {

    @Autowired
    private MatchingService matchingService;

    @PostMapping(path = "/match", consumes = "application/json", produces = "application/json")
    public void matchUsers(@RequestBody UserDto userDto1, @RequestBody UserDto userDto2) {
        matchingService.matchUsers(userDto1, userDto1);
    }

    @GetMapping(value = "matchList")
    public ResponseEntity<MatchUserDto> getPreMatchUsersByUserId(@RequestParam String userId) {
        MatchUserDto matchDto = matchingService.findPreMatchingByUserId(userId);
        return new ResponseEntity(matchDto, HttpStatus.OK);
    }
}
