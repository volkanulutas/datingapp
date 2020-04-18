package com.datingapp.user.service;

import com.datingapp.user.data.dto.AvailableUserDto;
import com.datingapp.user.data.dto.UserDto;

import java.util.List;
import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserService {

    Optional<UserDto> saveUser(UserDto user);

    List<UserDto> getAllUser();

    void sendAvailableUser(AvailableUserDto dto);

    boolean deleteUser(String username);

    UserDto findUserByUsername(String username);
}
