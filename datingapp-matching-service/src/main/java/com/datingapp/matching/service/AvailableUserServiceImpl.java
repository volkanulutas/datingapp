package com.datingapp.matching.service;

import com.datingapp.matching.converter.AvailableUserConverter;
import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.common.EnumUserStatus;
import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.data.entity.AvailableUser;
import com.datingapp.matching.repository.AvailableUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11.04.2020
 *
 * @author volkanulutas
 */
@Service
public class AvailableUserServiceImpl implements AvailableUserService {

    @Autowired
    private AvailableUserConverter availableUserConverter;

    @Autowired
    private AvailableUserRepository availableUserRepository;

    @Override
    public boolean save(AvailableUserDto availableUserDto) {
        AvailableUser save = availableUserRepository.save(availableUserConverter.toEntity(availableUserDto));
        return save != null;
    }

    @Override
    public List<AvailableUserDto> getAvailableUsers() {
        List<AvailableUserDto> availableUserDtoList = new ArrayList<>();

        List<AvailableUser> availableUserList = availableUserRepository.findAll();
        availableUserList.forEach(availableUser -> {
            AvailableUserDto availableUserDto = availableUserConverter.toDto(availableUser);
            availableUserDtoList.add(availableUserDto);
        });
        return availableUserDtoList;
    }

    @Override
    public AvailableUserDto findByUsername(String username) {
        return availableUserConverter.toDto(availableUserRepository.findByUsername(username));
    }

    @Override
    public List<AvailableUserDto> findByGender(EnumUserGender gender) {
        return availableUserRepository.findByGenderAndStatus(gender , EnumUserStatus.ONLINE);
    }
}
