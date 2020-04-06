package com.datingapp.game.converter;

import com.datingapp.game.data.dto.ParticipantDto;
import com.datingapp.game.data.entity.ParticipantEntity;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

@Converter
public class ParticipantConverter extends BaseConverter<ParticipantDto, ParticipantEntity> {

    @Override
    public ParticipantDto toDto(ParticipantEntity entity) {
        ParticipantDto dto = new ParticipantDto();
        dto.setId(entity.getId());
        dto.setNickname(entity.getNickname());
//        for (ParticipantFeatureEntity participantFeatureEntity : entity.getFeatureList()) {
//            
//        }
        return dto;
    }

    @Override
    public ParticipantEntity toEntity(ParticipantDto dto) {
        ParticipantEntity entity = new ParticipantEntity();
        entity.setId(dto.getId());
        entity.setNickname(dto.getNickname());
//        for (ParticipantFeatureDto participantFeatureDto : dto.getFeatureList()) {
//
//        }
        return entity;
    }
}
