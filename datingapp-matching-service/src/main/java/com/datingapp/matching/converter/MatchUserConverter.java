package com.datingapp.matching.converter;

import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.dto.UserDto;
import com.datingapp.matching.data.entity.MatchUser;
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
public class MatchUserConverter extends BaseConverter<MatchUserDto, MatchUser> {

    @Autowired
    private UserConverter userConverter;

    @Override
    public MatchUserDto toDto(MatchUser source) {
        if (source == null) {
            return null;
        }
        MatchUserDto target = new MatchUserDto();
        target.setId(source.getId());
        target.setUser(userConverter.toDto(source.getUser()));
        target.setDeleted(source.isDeleted());
        List<UserDto> matchingDtoList = new ArrayList<>();
        List<User> matchingList = source.getMatchingList();
        if (matchingList != null) {
            matchingList.forEach(u -> {
                matchingDtoList.add(userConverter.toDto(u));
            });
        }
        target.setMatchingList(matchingDtoList);
        return target;
    }

    @Override
    public MatchUser toEntity(MatchUserDto source) {
        if (source == null) {
            return null;
        }
        MatchUser target = new MatchUser();
        target.setId(source.getId());
        target.setDeleted(source.isDeleted());
        target.setUser(userConverter.toEntity(source.getUser()));
        List<User> matchingList = new ArrayList<>();
        List<UserDto> matchingDtoList = source.getMatchingList();
        if (matchingDtoList != null) {
            matchingDtoList.forEach(u -> {
                        matchingList.add(userConverter.toEntity(u));
                    }
            );
        }
        target.setMatchingList(matchingList);
        return target;
    }
}
