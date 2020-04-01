package com.datingapp.auth.converter;

import com.datingapp.auth.data.dto.AppUserDto;
import com.datingapp.auth.data.entity.AppUser;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Converter
public class AppUserConverter extends BaseConverter<AppUserDto, AppUser> {

    @Override
    public AppUserDto toDto(AppUser entity) {
        AppUserDto dto = new AppUserDto();
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
        return dto;
    }

    @Override
    public AppUser toEntity(AppUserDto dto) {
        AppUser entity = new AppUser();
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
        return entity;
    }
}
