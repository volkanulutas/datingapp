package com.datingapp.matching.service;

import com.datingapp.matching.converter.MatchUserConverter;
import com.datingapp.matching.converter.UserConverter;
import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.dto.UserDto;
import com.datingapp.matching.data.entity.MatchUser;
import com.datingapp.matching.data.entity.User;
import com.datingapp.matching.feign.UserServiceInterface;
import com.datingapp.matching.repository.MatchingUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Slf4j
@Service
public class MatchingServiceImpl implements MatchingService {
    @Autowired
    private MatchingUserRepository matchingUserRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private MatchUserConverter matchUserConverter;

    @Autowired
    private UserServiceInterface userServiceInterface;

    @Override
    public MatchUserDto findMatchingByUsername(String username) {
        List<MatchUser> matchUserDtoList = matchingUserRepository.findByUser_UsernameAndIsDeleted(username, false);
        if (matchUserDtoList.isEmpty()) {
            return null;
        }
        return matchUserConverter.toDto(matchUserDtoList.get(0));
    }

    private MatchUser findMatchingDataByUsername(String username) {
        List<MatchUser> matchUserDtoList = matchingUserRepository.findByUser_UsernameAndIsDeleted(username, false);
        if (matchUserDtoList.isEmpty()) {
            return null;
        }
        return matchUserDtoList.get(0);
    }

    @Override
    public boolean matchUsers(String username1, String username2) {
        try {
            UserDto userDto1 = userServiceInterface.findUserByUsername(username1).getBody();
            UserDto userDto2 = userServiceInterface.findUserByUsername(username2).getBody();
            if (userDto1 == null || userDto2 == null) {
                log.error("User not found to match");
                return false;
            }
            handleMatchingsOfUser(userDto1, userDto2);
            handleMatchingsOfUser(userDto2, userDto1);
        } catch (Exception ex) {
            log.error("Connection error to datingapp-user-service");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteMatch(String username, String matchUsername) {
        try {
            boolean b1 = handleRemoveOfMatching(username, matchUsername);
            boolean b2 = handleRemoveOfMatching(matchUsername, username);
            return b1 && b2;
        } catch (Exception ex) {
            log.error("delete match error");
            return false;
        }
    }

    private boolean handleRemoveOfMatching(String username, String matchUsername) {
        try {
            MatchUserDto matchUserDto = findMatchingByUsername(username);
            if (matchUserDto == null) {
                return false;
            }
            List<User> matchingList = matchUserDto.getMatchingList();
            if (matchingList.isEmpty()) {
                return false;
            }
            List<User> tempMatchingList = new ArrayList<>();
            for (User user : matchingList) {
                if (!user.getUsername().equals(matchUsername)) {
                    tempMatchingList.add(user);
                }
            }
            matchUserDto.setMatchingList(tempMatchingList);
            MatchUser save = matchingUserRepository.save(matchUserConverter.toEntity(matchUserDto));
            return save != null;
        } catch (Exception ex) {
            log.error("handle Remove Matching error.", ex);
        }
        return false;
    }

    private void handleMatchingsOfUser(UserDto sourceUserDto, UserDto targetUserDto) {
        MatchUser sourceMatchingUser = findMatchingDataByUsername(sourceUserDto.getUsername());
        if (sourceMatchingUser == null) { // There is no matching object
            sourceMatchingUser = new MatchUser();
            List<User> matchingList = new ArrayList<>();
            sourceMatchingUser.setUser(userConverter.toEntity(sourceUserDto));
            matchingList.add(userConverter.toEntity(targetUserDto));
            sourceMatchingUser.setMatchingList(matchingList);
        } else {  // There is matching object
            List<User> matchingList = sourceMatchingUser.getMatchingList();
            if (matchingList == null) { // There are no matchers before
                matchingList = new ArrayList<>();
                matchingList.add(userConverter.toEntity(targetUserDto));
                sourceMatchingUser.setMatchingList(matchingList);
            } else { // There are matchers also
                if (!containsMatchList(matchingList, targetUserDto.getUsername())) { // If there is not matched before
                    sourceMatchingUser.setUser(userConverter.toEntity(sourceUserDto));
                    matchingList.add(userConverter.toEntity(targetUserDto));
                    sourceMatchingUser.setMatchingList(matchingList);
                }
            }
        }
        matchingUserRepository.save(sourceMatchingUser); // TODO: save metot olsun.
    }

    private boolean containsMatchList(List<User> matchingList, String username) {
        for (User user : matchingList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
}