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
        MatchUserDto matchUserDto = findMatchingByUsername(username);
        List<User> matchingList = matchUserDto.getMatchingList();
        if (matchingList.isEmpty()) {
            return false;
        }
        User deletedObject = null;
        for (User user : matchingList) {
            if (user.getUsername().equals(matchUsername)) {
                deletedObject = user;
                break;
            }
        }
        if (deletedObject != null) {
            matchingList.remove(deletedObject);
        }
        MatchUser save = matchingUserRepository.save(matchUserConverter.toEntity(matchUserDto));

        return save != null;
    }

    private void handleMatchingsOfUser(UserDto sourceUserDto, UserDto targetUserDto) {
        MatchUser sourceMatchingUser = findMatchingDataByUsername(sourceUserDto.getUsername());
        if (sourceMatchingUser == null) { // There are no matchers case
            sourceMatchingUser = new MatchUser();
            List<User> sourceMatchingList = new ArrayList<>();
            sourceMatchingList.add(userConverter.toEntity(targetUserDto));
            sourceMatchingUser.setMatchingList(sourceMatchingList);
            sourceMatchingUser.setUser(userConverter.toEntity(sourceUserDto));
        } else { // There are matchers also
            List<User> sourceMatchingList = sourceMatchingUser.getMatchingList();
            if (sourceMatchingList.contains(targetUserDto)) { // If there is already matched
                sourceMatchingList.add(userConverter.toEntity(targetUserDto));
            }
            sourceMatchingUser.setMatchingList(sourceMatchingList);
        }
        matchingUserRepository.save(sourceMatchingUser); // TODO: save metot olsun.
    }
}