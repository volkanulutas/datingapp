package com.datingapp.user.service;

import com.datingapp.user.config.ApplicationConfig;
import com.datingapp.user.config.RabbitMQSender;
import com.datingapp.user.constant.ErrorMessageConstants;
import com.datingapp.user.converter.AvailableUserConverter;
import com.datingapp.user.converter.UserConverter;
import com.datingapp.user.data.dto.AvailableUserDto;
import com.datingapp.user.data.dto.UserDto;
import com.datingapp.user.data.entity.User;
import com.datingapp.user.exception.ErrorResponse;
import com.datingapp.user.exception.SignupException;
import com.datingapp.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserConverter userConverter;

    /*
    @Autowired
    private BCryptPasswordEncoder encoder;
     */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @Autowired
    private AvailableUserConverter availableUserConverter;

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    public Optional<UserDto> saveUser(UserDto userDto) {
        User user = findUserByUsernameData(userDto.getUsername());
        if (user != null) {
            userDto.setId(user.getId());
        }
        user = userConverter.toEntity(userDto, user); // TODO: pass param engellenebilir mi

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        User savedUser = userRepository.save(user);
        UserDto appUserDto = Optional.of(userConverter.toDto(savedUser)).orElseThrow(
                () -> new SignupException(new ErrorResponse(ErrorMessageConstants.SingupErrorMessage.MESSAGE,
                        ErrorMessageConstants.SingupErrorMessage.DEVELOPER_MESSAGE)));
        // trigger to change of user
        AvailableUserDto avUserDto = availableUserConverter.toDto(savedUser);
        rabbitMQSender.send(applicationConfig.getAvailableMatchQueueExchange(),
                applicationConfig.getAvailableMatchQueueRoutingKey(),
                avUserDto);
        return Optional.of(appUserDto);
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return userConverter.toDto(findUserByUsernameData(username));
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> userList = userRepository.findByIsDeleted(false);
        userList.forEach(u -> userDtoList.add(userConverter.toDto(u)));
        return userDtoList;
    }

    @Override
    public void sendAvailableUser(AvailableUserDto dto) {
        rabbitMQSender.send(applicationConfig.getAvailableMatchQueueExchange(),
                applicationConfig.getAvailableMatchQueueRoutingKey(),
                dto);
    }

    @Override
    public boolean deleteUser(String username) {
        UserDto userDto = findUserByUsername(username);
        if (userDto != null) {
            userDto.setDeleted(true);
            Optional<UserDto> save = saveUser(userDto);
            return save != null;
        } else {
            return false;
        }
    }

    private User findUserByUsernameData(String username) {
        return userRepository.findByUsernameAndIsDeleted(username, false);
    }
}
