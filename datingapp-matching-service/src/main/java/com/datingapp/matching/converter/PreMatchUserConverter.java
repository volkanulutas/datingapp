package com.datingapp.matching.converter;

import com.datingapp.matching.controller.BaseConverter;
import com.datingapp.matching.data.dto.PreMatchUserDto;
import com.datingapp.matching.data.entity.PreMatchUser;
import org.springframework.stereotype.Component;

@Component
public class PreMatchUserConverter extends BaseConverter<PreMatchUserDto, PreMatchUser> {
    @Override
    public PreMatchUserDto toDto(PreMatchUser entity) {
        PreMatchUserDto target = new PreMatchUserDto();
        target.setId(entity.getId());
        target.setUser(entity.getUser());
        target.setMatchingList(entity.getMatchingList());
        return target;
    }

    @Override
    public PreMatchUser toEntity(PreMatchUserDto dto) {
        PreMatchUser target = new PreMatchUser();
        target.setId(dto.getId());
        target.setMatchingList(dto.getMatchingList());
        target.setUser(dto.getUser());
        return target;
    }
}
