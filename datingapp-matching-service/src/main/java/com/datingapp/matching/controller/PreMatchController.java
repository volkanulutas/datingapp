package com.datingapp.matching.controller;

import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.data.dto.PreMatchUserDto;
import com.datingapp.matching.service.PreMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@RestController
@RequestMapping("/pre")
public class PreMatchController {

    @Autowired
    private PreMatchingService preMatchingService;

    @GetMapping(value = "/matchList")
    public ResponseEntity<AvailableUserDto> getPreMatch(@RequestParam String username) {
        PreMatchUserDto preMatchDto = preMatchingService.findPreMatchingByUsername(username);
        return new ResponseEntity(preMatchDto, HttpStatus.OK);
    }
}
