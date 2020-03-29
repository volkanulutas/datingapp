package com.datingapp.auth.service;

import com.datingapp.auth.data.entity.AppUser;

import java.util.List;
import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserService {

    Optional<AppUser> createUser(AppUser user);

    Optional<AppUser> findUserByUsername(String username);

    List<AppUser> getAllUser();
}
