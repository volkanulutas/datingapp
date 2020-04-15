package com.datingapp.auth.converter;

import com.datingapp.auth.data.dto.AvailableUserDto;
import com.datingapp.auth.data.entity.User;
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
        AvailableUserDto dto = new AvailableUserDto();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setBirthDate(entity.getBirthDate());
        dto.setBirthPlace(entity.getBirthPlace());
        dto.setStatus(entity.getStatus());
        if (entity.getUserPreference() != null) {
            dto.setUserPreferenceDto(userPreferenceConverter.toDto(entity.getUserPreference()));
        }
        return dto;
    }

    @Override
    public User toEntity(AvailableUserDto dto) {
        if (dto == null) {
            return null;
        }
        User entity = new User();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setBirthDate(dto.getBirthDate());
        entity.setBirthPlace(dto.getBirthPlace());
        entity.setStatus(dto.getStatus());
        if (dto.getUserPreferenceDto() != null) {
            entity.setUserPreference(userPreferenceConverter.toEntity(dto.getUserPreferenceDto()));
        }
        return entity;
    }
}
