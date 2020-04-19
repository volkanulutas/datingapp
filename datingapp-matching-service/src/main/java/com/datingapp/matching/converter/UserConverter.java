package com.datingapp.matching.converter;

import com.datingapp.matching.data.dto.UserDto;
import com.datingapp.matching.data.entity.User;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Component
public class UserConverter extends BaseConverter<UserDto, User> {
    @Override
    public UserDto toDto(User source) {
        if (source == null) {
            return null;
        }
        UserDto target = new UserDto();
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setGender(source.getGender());
        target.setId(source.getId());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setDeleted(source.isDeleted());
        target.setStatus(source.getStatus());
        return target;
    }

    @Override
    public User toEntity(UserDto source) {
        if (source == null) {
            return null;
        }
        User target = new User();
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setGender(source.getGender());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setDeleted(source.isDeleted());
        target.setId(source.getId());
        target.setStatus(source.getStatus());
        return target;
    }
}
