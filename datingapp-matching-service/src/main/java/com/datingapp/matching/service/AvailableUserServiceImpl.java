package com.datingapp.matching.service;

import com.datingapp.matching.constant.ErrorMessageConstants;
import com.datingapp.matching.converter.AvailableUserConverter;
import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.common.EnumUserStatus;
import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.data.entity.AvailableUser;
import com.datingapp.matching.exception.AvailableUserException;
import com.datingapp.matching.exception.ErrorResponse;
import com.datingapp.matching.repository.AvailableUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private AvailableUser findAvailableUserByUsernameData(String username) {
        return availableUserRepository.findByUsernameAndIsDeleted(username, false);
    }

    @Override
    public Optional<AvailableUserDto> save(AvailableUserDto availableUserDto) {
        AvailableUser availableUser = findAvailableUserByUsernameData(availableUserDto.getUsername());
        if (availableUser == null) {
            availableUserDto.setId(availableUserDto.getId());
        }
        availableUser = availableUserConverter.toEntity(availableUserDto);
        AvailableUser savedAvUser = availableUserRepository.save(availableUser);

        AvailableUserDto avUserDto = Optional.of(availableUserConverter.toDto(savedAvUser)).orElseThrow(
                () -> new AvailableUserException(new ErrorResponse(ErrorMessageConstants.AvailableUser.MESSAGE,
                        ErrorMessageConstants.AvailableUser.DEVELOPER_MESSAGE)));
        return Optional.of(avUserDto);
    }

    @Override
    public List<AvailableUserDto> getAvailableUsers() {
        List<AvailableUserDto> availableUserDtoList = new ArrayList<>();
        List<AvailableUser> availableUserList = availableUserRepository.findByIsDeleted(false);
        availableUserList.forEach(availableUser -> {
            AvailableUserDto availableUserDto = availableUserConverter.toDto(availableUser);
            availableUserDtoList.add(availableUserDto);
        });
        return availableUserDtoList;
    }

    @Override
    public AvailableUserDto findByUsername(String username) {
        AvailableUser avUser = availableUserRepository.findByUsernameAndIsDeleted(username, false);
        return availableUserConverter.toDto(avUser);
    }

    @Override
    public List<AvailableUserDto> findByGender(EnumUserGender gender) {
        return availableUserRepository.findByGenderAndStatusAndIsDeleted(gender, EnumUserStatus.ONLINE, false);
    }
}
