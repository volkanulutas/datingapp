package com.datingapp.auth.service;

import com.datingapp.auth.constant.ErrorMessageConstants;
import com.datingapp.auth.converter.AppUserConverter;
import com.datingapp.auth.data.dto.AppUserDto;
import com.datingapp.auth.data.entity.AppUser;
import com.datingapp.auth.exception.SignupException;
import com.datingapp.auth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AppUserConverter appUserConverter;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<AppUserDto> createUser(AppUserDto user) throws RuntimeException {
        AppUser appUser = findUserByUsername(user.getUsername()).orElse(appUserConverter.toEntity(user));
        String encodedPassword = encoder.encode(appUser.getPassword());
        appUser.setPassword(encodedPassword);
        AppUser savedUser = userRepository.save(appUser);
        AppUserDto appUserDto = Optional.of(appUserConverter.toDto(savedUser)).orElseThrow(
                () -> new SignupException(ErrorMessageConstants.SingupErrorMessage.MESSAGE, ErrorMessageConstants.SingupErrorMessage.DEVELOPER_MESSAGE));
        return Optional.of(appUserDto);
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
