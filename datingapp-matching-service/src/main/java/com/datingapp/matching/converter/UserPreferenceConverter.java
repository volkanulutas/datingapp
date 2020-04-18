package com.datingapp.matching.converter;

import com.datingapp.matching.data.dto.UserPreferenceDto;
import com.datingapp.matching.data.entity.UserPreference;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Component
public class UserPreferenceConverter extends BaseConverter<UserPreferenceDto, UserPreference> {

    @Override
    public UserPreferenceDto toDto(UserPreference entity) {
        if (entity == null) {
            return null;
        }
        UserPreferenceDto target = new UserPreferenceDto();
        target.setGender(entity.getGender());
        target.setMaximumAge(entity.getMaximumAge());
        target.setMinimumAge(entity.getMinimumAge());
        target.setGender(entity.getGender());
        return target;
    }

    @Override
    public UserPreference toEntity(UserPreferenceDto dto) {
        if (dto == null) {
            return null;
        }
        UserPreference target = new UserPreference();
        target.setGender(dto.getGender());
        target.setMaximumAge(dto.getMaximumAge());
        target.setMinimumAge(dto.getMinimumAge());
        target.setPlaceRange(dto.getPlaceRange());
        return target;
    }
}
