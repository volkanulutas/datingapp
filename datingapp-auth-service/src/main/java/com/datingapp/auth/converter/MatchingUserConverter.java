package com.datingapp.auth.converter;

import com.datingapp.auth.data.dto.matchingservice.AvailableMatchingUserDto;
import com.datingapp.auth.data.entity.AppUser;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Converter
public class MatchingUserConverter extends BaseConverter<AvailableMatchingUserDto, AppUser> {

    @Override
    public AvailableMatchingUserDto toDto(AppUser entity) {
        AvailableMatchingUserDto dto = new AvailableMatchingUserDto();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setUsername(entity.getUsername());
        dto.setBirthDate(entity.getBirthDate());
        dto.setBirthPlace(entity.getBirthPlace());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    @Override
    public AppUser toEntity(AvailableMatchingUserDto dto) {
        AppUser entity = new AppUser();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setUsername(dto.getUsername());
        entity.setBirthDate(dto.getBirthDate());
        entity.setBirthPlace(dto.getBirthPlace());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}
