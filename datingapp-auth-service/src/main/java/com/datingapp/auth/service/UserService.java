package com.datingapp.auth.service;

import com.datingapp.auth.data.dto.AppUserDto;
import com.datingapp.auth.data.dto.matchingservice.AvailableMatchingUserDto;
import com.datingapp.auth.data.entity.AppUser;

import java.util.List;
import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserService {

    Optional<AppUserDto> createUser(AppUserDto user);

    Optional<AppUser> findUserByUsername(String username);

    List<AppUser> getAllUser();

    List<AppUser> getAvailableMatchingUser();

    void sendAvailableMatchingUser(AvailableMatchingUserDto dto);

}
