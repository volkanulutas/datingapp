package com.datingapp.user.converter;

import com.datingapp.user.data.dto.UserDto;
import com.datingapp.user.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Converter
public class UserConverter extends BaseConverter<UserDto, User> {

    @Autowired
    private UserPreferenceConverter userPreferenceConverter;

    @Override
    public UserDto toDto(User source) {
        if (source == null) {
            return null;
        }
        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setDeleted(source.isDeleted());
        target.setGender(source.getGender());
        target.setLoginAttempt(source.getLoginAttempt());
        target.setUserRole(source.getUserRole());
        target.setStatus(source.getStatus());
        target.setUserPicture(source.getUserPicture());
        target.setUserPreference(userPreferenceConverter.toDto(source.getUserPreference()));
        return target;
    }

    @Override
    public User toEntity(UserDto source) {
        if (source == null) {
            return null;
        }
        User target = new User();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setBirthDate(source.getBirthDate());
        target.setGender(source.getGender());
        target.setBirthPlace(source.getBirthPlace());
        target.setDeleted(source.isDeleted());
        target.setLoginAttempt(source.getLoginAttempt());
        target.setUserRole(source.getUserRole());
        target.setStatus(source.getStatus());
        target.setUserPicture(source.getUserPicture());
        target.setUserPreference(userPreferenceConverter.toEntity(source.getUserPreference()));
        return target;
    }

    @Override
    public User toEntity(UserDto source, User target) {
        if (source == null) {
            return null;
        }
        if (target == null) {
            target = new User();
        }
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setPassword(source.getPassword());
        target.setBirthDate(source.getBirthDate());
        target.setGender(source.getGender());
        target.setBirthPlace(source.getBirthPlace());
        target.setDeleted(source.isDeleted());
        target.setLoginAttempt(source.getLoginAttempt());
        target.setUserRole(source.getUserRole());
        target.setStatus(source.getStatus());
        target.setUserPicture(source.getUserPicture());
        target.setUserPreference(userPreferenceConverter.toEntity(source.getUserPreference()));
        return target;
    }
}