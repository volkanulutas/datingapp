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
    public AvailableUserDto toDto(User source) {
        if (source == null) {
            return null;
        }
        AvailableUserDto target = new AvailableUserDto();
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setDeleted(source.isDeleted());
        target.setGender(source.getGender());
        target.setStatus(source.getStatus());
        if (source.getUserPreference() != null) {
            target.setUserPreference(userPreferenceConverter.toDto(source.getUserPreference()));
        }
        return target;
    }

    @Override
    public User toEntity(AvailableUserDto source) {
        if (source == null) {
            return null;
        }
        User target = new User();
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setUsername(source.getUsername());
        target.setBirthDate(source.getBirthDate());
        target.setBirthPlace(source.getBirthPlace());
        target.setStatus(source.getStatus());
        target.setGender(source.getGender());
        target.setDeleted(source.isDeleted());
        if (source.getUserPreference() != null) {
            target.setUserPreference(userPreferenceConverter.toEntity(source.getUserPreference()));
        }
        return target;
    }
}
