package com.datingapp.auth.service;

import com.datingapp.auth.data.dto.UserDto;
import com.datingapp.auth.data.dto.AvailableUserDto;
import com.datingapp.auth.data.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserService {

    Optional<UserDto> saveUser(UserDto user);

    User findUserByUsername(String username);

    List<User> getAllUser();

    List<User> getAvailableUser();

    void sendAvailableUser(AvailableUserDto dto);
}
