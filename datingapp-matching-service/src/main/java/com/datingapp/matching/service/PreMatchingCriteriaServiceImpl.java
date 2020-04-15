package com.datingapp.matching.service;

import com.datingapp.matching.converter.PreMatchUserConverter;
import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.dto.PreMatchUserDto;
import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.data.dto.UserPreferenceDto;
import com.datingapp.matching.data.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class PreMatchingCriteriaServiceImpl implements PreMatchingCriteriaService {

    @Autowired
    private AvailableUserService availableUserService;

    @Autowired
    private PreMatchUserConverter preMatchUserConverter;

    @Override
    public PreMatchUserDto getPreMatchingUserByCriteria(String username) {
        PreMatchUserDto result = new PreMatchUserDto();

        AvailableUserDto user = availableUserService.findByUsername(username);
        UserPreferenceDto userPreference = user.getUserPreference();
        EnumUserGender gender = userPreference.getGender();

        // criteria management
        // make integration: https://blog.marcnuri.com/spring-data-mongodb-custom-repository-implementation/
        List<AvailableUserDto> availableUserList = availableUserService.findByGender(gender);
        AvailableUserDto avMatchingUser = availableUserList.get(0);

        UserDto userDto = new UserDto();
        userDto.setStatus(user.getStatus());
        userDto.setUsername(user.getUsername());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setId(user.getId());
        userDto.setGender(user.getGender());
        userDto.setBirthPlace(user.getBirthPlace());
        userDto.setBirthDate(user.getBirthDate());

        UserDto matchingUser = new UserDto();
        matchingUser.setBirthDate(avMatchingUser.getBirthDate());
        matchingUser.setBirthPlace(avMatchingUser.getBirthPlace());
        matchingUser.setGender(avMatchingUser.getGender());
        matchingUser.setId(avMatchingUser.getId());
        matchingUser.setName(avMatchingUser.getName());
        matchingUser.setSurname(avMatchingUser.getSurname());
        matchingUser.setUsername(avMatchingUser.getUsername());
        matchingUser.setStatus(avMatchingUser.getStatus());

        result.setUser(userDto);
        result.setId(userDto.getId());
        result.getMatchingList().add(matchingUser);

        return result;
    }
}
