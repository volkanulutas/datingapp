package com.datingapp.matching.converter;

import com.datingapp.matching.controller.BaseConverter;
import com.datingapp.matching.data.dto.gameservice.UserDto;
import com.datingapp.matching.data.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends BaseConverter<UserDto, User> {
    @Override
    public UserDto toDto(User entity) {
        UserDto target = new UserDto();
        target.setBirthDate(entity.getBirthDate());
        target.setBirthPlace(entity.getBirthPlace());
        target.setGender(entity.getGender());
        target.setId(entity.getId());
        target.setName(entity.getName());
        target.setSurname(entity.getSurname());
        target.setUsername(entity.getUsername());
        target.setStatus(entity.getStatus());
        return target;
    }

    @Override
    public User toEntity(UserDto dto) {
        User target = new User();
        target.setBirthDate(dto.getBirthDate());
        target.setBirthPlace(dto.getBirthPlace());
        target.setGender(dto.getGender());
        target.setName(dto.getName());
        target.setSurname(dto.getSurname());
        target.setUsername(dto.getUsername());
        target.setId(dto.getId());
        target.setStatus(dto.getStatus());
        return target;
    }
}
