package com.datingapp.matching.converter;

import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.data.entity.AvailableUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Component
public class AvailableUserConverter extends BaseConverter<AvailableUserDto, AvailableUser> {

    @Autowired
    private UserPreferenceConverter userPreferenceConverter;

    @Override
    public AvailableUserDto toDto(AvailableUser entity) {
        if (entity == null) {
            return null;
        }
        AvailableUserDto target = new AvailableUserDto();
        target.setBirthDate(entity.getBirthDate());
        target.setBirthPlace(entity.getBirthPlace());
        target.setGender(entity.getGender());
        target.setId(entity.getId());
        target.setName(entity.getName());
        target.setSurname(entity.getSurname());
        target.setStatus(entity.getStatus());
        target.setUsername(entity.getUsername());
        target.setUserPreference(userPreferenceConverter.toDto(entity.getUserPreference()));
        return target;
    }

    @Override
    public AvailableUser toEntity(AvailableUserDto dto) {
        if (dto == null) {
            return null;
        }
        AvailableUser target = new AvailableUser();
        target.setBirthDate(dto.getBirthDate());
        target.setBirthPlace(dto.getBirthPlace());
        target.setGender(dto.getGender());
        target.setId(dto.getId());
        target.setName(dto.getName());
        target.setSurname(dto.getSurname());
        target.setStatus(dto.getStatus());
        target.setUsername(dto.getUsername());
        target.setUserPreference(userPreferenceConverter.toEntity(dto.getUserPreference()));
        return target;
    }
}
