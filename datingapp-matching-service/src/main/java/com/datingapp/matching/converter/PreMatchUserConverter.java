package com.datingapp.matching.converter;

import com.datingapp.matching.data.dto.PreMatchUserDto;
import com.datingapp.matching.data.dto.UserDto;
import com.datingapp.matching.data.entity.PreMatchUser;
import com.datingapp.matching.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Component
public class PreMatchUserConverter extends BaseConverter<PreMatchUserDto, PreMatchUser> {
    @Autowired
    private UserConverter userConverter;

    @Override
    public PreMatchUserDto toDto(PreMatchUser source) {
        if (source == null) {
            return null;
        }
        PreMatchUserDto target = new PreMatchUserDto();
        target.setId(source.getId());
        target.setDeleted(source.isDeleted());
        target.setUser(userConverter.toDto(source.getUser()));
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : source.getMatchingList()) {
            userDtoList.add(userConverter.toDto(user));
        }
        target.setMatchingList(userDtoList);
        return target;
    }

    @Override
    public PreMatchUser toEntity(PreMatchUserDto source) {
        if (source == null) {
            return null;
        }
        PreMatchUser target = new PreMatchUser();
        target.setId(source.getId());
        target.setDeleted(source.isDeleted());
        target.setUser(userConverter.toEntity(source.getUser()));
        List<User> userList = new ArrayList<>();
        for (UserDto user : source.getMatchingList()) {
            userList.add(userConverter.toEntity(user));
        }
        target.setMatchingList(userList);
        return target;
    }
}
