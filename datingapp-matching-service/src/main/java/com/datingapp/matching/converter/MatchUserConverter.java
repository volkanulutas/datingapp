package com.datingapp.matching.converter;

import com.datingapp.matching.data.dto.MatchUserDto;
import com.datingapp.matching.data.entity.MatchUser;
import org.springframework.stereotype.Component;

/**
 * Created on 12.04.2020
 *
 * @author volkanulutas
 */
@Component
public class MatchUserConverter extends BaseConverter<MatchUserDto, MatchUser> {
    @Override
    public MatchUserDto toDto(MatchUser source) {
        if (source == null) {
            return null;
        }
        MatchUserDto target = new MatchUserDto();
        target.setId(source.getId());
        target.setUser(source.getUser());
        target.setDeleted(source.isDeleted());
        target.setMatchingList(source.getMatchingList());
        return target;
    }

    @Override
    public MatchUser toEntity(MatchUserDto source) {
        if (source == null) {
            return null;
        }
        MatchUser target = new MatchUser();
        target.setId(source.getId());
        target.setDeleted(source.isDeleted());
        target.setMatchingList(source.getMatchingList());
        target.setUser(source.getUser());
        return target;
    }
}
