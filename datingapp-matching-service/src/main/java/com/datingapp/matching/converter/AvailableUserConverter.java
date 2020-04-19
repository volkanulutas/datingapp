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
    public AvailableUserDto toDto(AvailableUser source) {
        if (source == null) {
            return null;
        }
        AvailableUserDto target = new AvailableUserDto();
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setGender(source.getGender());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setStatus(source.getStatus());
        target.setUsername(source.getUsername());
        target.setDeleted(source.isDeleted());
        target.setUserPreference(userPreferenceConverter.toDto(source.getUserPreference()));
        return target;
    }

    @Override
    public AvailableUser toEntity(AvailableUserDto source) {
        if (source == null) {
            return null;
        }
        AvailableUser target = new AvailableUser();
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setGender(source.getGender());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setStatus(source.getStatus());
        target.setUsername(source.getUsername());
        target.setDeleted(source.isDeleted());
        target.setUserPreference(userPreferenceConverter.toEntity(source.getUserPreference()));
        return target;
    }

    @Override
    public AvailableUser toEntity(AvailableUserDto source, AvailableUser target) {
        if (source == null) {
            return null;
        }
        if (target == null) {
            target = new AvailableUser();
        }
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setGender(source.getGender());
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setStatus(source.getStatus());
        target.setUsername(source.getUsername());
        target.setDeleted(source.isDeleted());
        target.setUserPreference(userPreferenceConverter.toEntity(source.getUserPreference()));
        return target;
    }
}
