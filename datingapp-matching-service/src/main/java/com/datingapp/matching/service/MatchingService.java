package com.datingapp.matching.service;

import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.dto.gameservice.UserDto;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface MatchingService {
    MatchUserDto findPreMatchingByUserId(String userId);

    void matchUsers(UserDto userDto1, UserDto userDto2);
}
