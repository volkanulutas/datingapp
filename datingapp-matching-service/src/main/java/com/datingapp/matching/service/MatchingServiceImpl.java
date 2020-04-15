package com.datingapp.matching.service;

import com.datingapp.matching.converter.MatchUserConverter;
import com.datingapp.matching.converter.UserConverter;
import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.dto.UserDto;
import com.datingapp.matching.data.entity.MatchUser;
import com.datingapp.matching.data.entity.User;
import com.datingapp.matching.repository.MatchingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class MatchingServiceImpl implements MatchingService {
    @Autowired
    private MatchingUserRepository matchingUserRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private MatchUserConverter matchUserConverter;

    @Override
    public MatchUserDto findMachingByUserId(String userId) {
        AtomicReference<MatchUserDto> result = null;
        List<MatchUser> matchUserDtoList = matchingUserRepository.findByUser_Id(userId);
        Optional.of(matchUserDtoList).ifPresent(preMatchDtos -> {
            MatchUser matchUser = matchUserDtoList.get(0);
            result.set(matchUserConverter.toDto(matchUser));
        });
        return result.get();
    }

    @Override
    public void matchUsers(UserDto userDto1, UserDto userDto2) {
        MatchUser matchUser1 = null;
        MatchUser matchUser2 = null;

        MatchUserDto matchUserDto1 = findMachingByUserId(userDto1.getId());
        if (matchUserDto1 == null) {
            matchUser1 = new MatchUser();
            List<User> matchingList1 = new ArrayList<>();
            matchingList1.add(userConverter.toEntity(userDto2));
            matchUser1.setMatchingList(matchingList1);
            matchUser1.setUser(userConverter.toEntity(userDto1));
            matchingUserRepository.save(matchUser1);
        } else {
            matchUser1.setUser(userConverter.toEntity(userDto1));
            List<User> matchingList2 = matchUserDto1.getMatchingList();
            matchingList2.add(userConverter.toEntity(userDto2));
            matchingUserRepository.save(matchUser1);
        }

        // matchUserDto2
        MatchUserDto matchUserDto2 = findMachingByUserId(userDto2.getId());
        if (matchUserDto2 == null) {
            matchUser2 = new MatchUser();
            List<User> matchingList2 = new ArrayList<>();
            matchingList2.add(userConverter.toEntity(userDto1));
            matchUser2.setMatchingList(matchingList2);
            matchUser2.setUser(userConverter.toEntity(userDto2));
            matchingUserRepository.save(matchUser2);
        } else {
            matchUser2.setUser(userConverter.toEntity(userDto2));
            List<User> matchingList2 = matchUserDto1.getMatchingList();
            matchingList2.add(userConverter.toEntity(userDto1));
            matchingUserRepository.save(matchUser2);
        }
    }
}
