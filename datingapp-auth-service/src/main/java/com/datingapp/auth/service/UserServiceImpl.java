package com.datingapp.auth.service;

import com.datingapp.auth.data.entity.AppUser;
import com.datingapp.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<AppUser> createUser(AppUser user) {
        AppUser appUser = findUserByUsername(user.getUsername()).orElse(user);
        String encodedPassword = encoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        return Optional.of(userRepository.save(appUser));
    }

    @Override
    public Optional<AppUser> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAllUser() {
        return userRepository.findAll();
    }
}
