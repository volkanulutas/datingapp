package com.datingapp.matching.service;

import com.datingapp.matching.data.dto.MatchUserDto;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface MatchingService {
    MatchUserDto findMatchingByUsername(String userId);

    boolean matchUsers(String username1, String username2);

    boolean deleteMatch(String username, String matchUsername);
}
