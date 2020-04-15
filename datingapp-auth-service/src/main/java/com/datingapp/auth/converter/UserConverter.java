package com.datingapp.auth.converter;

import com.datingapp.auth.data.dto.UserDto;
import com.datingapp.auth.data.entity.User;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Converter
public class UserConverter extends BaseConverter<UserDto, User> {

    @Override
    public UserDto toDto(User entity) {
        if (entity == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setBirthDate(entity.getBirthDate());
        dto.setBirthPlace(entity.getBirthPlace());
        dto.setLoginAttempt(entity.getLoginAttempt());
        dto.setUserRole(entity.getUserRole());
        dto.setStatus(entity.getStatus());
        dto.setUserPicture(entity.getUserPicture());
        dto.setUserPreference(entity.getUserPreference());
        return dto;
    }

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setBirthDate(dto.getBirthDate());
        entity.setBirthPlace(dto.getBirthPlace());
        entity.setLoginAttempt(dto.getLoginAttempt());
        entity.setUserRole(dto.getUserRole());
        entity.setStatus(dto.getStatus());
        entity.setUserPicture(dto.getUserPicture());
        entity.setUserPreference(dto.getUserPreference());
        return entity;
    }
}