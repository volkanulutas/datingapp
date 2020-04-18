package com.datingapp.matching.service;

import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.dto.AvailableUserDto;

import java.util.List;
import java.util.Optional;

/**
 * Created on 11.04.2020
 *
 * @author volkanulutas
 */
public interface AvailableUserService {
    Optional<AvailableUserDto> save(AvailableUserDto availableUserDto);

    List<AvailableUserDto> getAvailableUsers();

    AvailableUserDto findByUsername(String username);

    List<AvailableUserDto> findByGender(EnumUserGender gender);
}
