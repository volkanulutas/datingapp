package com.datingapp.matching.controller;

import com.datingapp.matching.data.dto.PreMatchUserDto;
import com.datingapp.matching.data.dto.authservice.AvailableMatchingUserDto;
import com.datingapp.matching.service.PreMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PreMatchController {

    @Autowired
    private PreMatchingService preMatchingService;

    @GetMapping(value = "preMatchList")
    public ResponseEntity<AvailableMatchingUserDto> getPreMatch(@RequestParam String userId) {
        PreMatchUserDto preMatchDto = preMatchingService.findPreMatchingByUserId(userId);
        return new ResponseEntity(preMatchDto, HttpStatus.OK);
    }
}
