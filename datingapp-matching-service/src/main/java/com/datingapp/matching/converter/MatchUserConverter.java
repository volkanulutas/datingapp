package com.datingapp.matching.converter;

import com.datingapp.matching.controller.BaseConverter;
import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.entity.MatchUser;
import org.springframework.stereotype.Component;

@Component
public class MatchUserConverter extends BaseConverter<MatchUserDto, MatchUser> {
    @Override
    public MatchUserDto toDto(MatchUser entity) {
        MatchUserDto target = new MatchUserDto();
        target.setId(entity.getId());
        target.setUser(entity.getUser());
        target.setMatchingList(entity.getMatchingList());
        return target;
    }

    @Override
    public MatchUser toEntity(MatchUserDto dto) {
        MatchUser target = new MatchUser();
        target.setId(dto.getId());
        target.setMatchingList(dto.getMatchingList());
        target.setUser(dto.getUser());
        return target;
    }
}
