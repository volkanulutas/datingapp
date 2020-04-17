package com.datingapp.user.converter;

import com.datingapp.user.data.dto.AvailableUserDto;
import com.datingapp.user.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Converter
public class AvailableUserConverter extends BaseConverter<AvailableUserDto, User> {

    @Autowired
    private UserPreferenceConverter userPreferenceConverter;

    @Override
    public AvailableUserDto toDto(User entity) {
        if (entity == null) {
            return null;
        }
        AvailableUserDto target = new AvailableUserDto();
        target.setName(entity.getName());
        target.setSurname(entity.getSurname());
        target.setUsername(entity.getUsername());
        target.setBirthDate(entity.getBirthDate());
        target.setBirthPlace(entity.getBirthPlace());
        target.setGender(entity.getGender());
        target.setStatus(entity.getStatus());
        if (entity.getUserPreference() != null) {
            target.setUserPreference(userPreferenceConverter.toDto(entity.getUserPreference()));
        }
        return target;
    }

    @Override
    public User toEntity(AvailableUserDto dto) {
        if (dto == null) {
            return null;
        }
        User target = new User();
        target.setName(dto.getName());
        target.setSurname(dto.getSurname());
        target.setUsername(dto.getUsername());
        target.setBirthDate(dto.getBirthDate());
        target.setBirthPlace(dto.getBirthPlace());
        target.setStatus(dto.getStatus());
        target.setGender(dto.getGender());
        if (dto.getUserPreference() != null) {
            target.setUserPreference(userPreferenceConverter.toEntity(dto.getUserPreference()));
        }
        return target;
    }
}
