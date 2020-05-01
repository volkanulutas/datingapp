package com.datingapp.game.converter;

import com.datingapp.game.data.dto.ParticipantFeatureDto;
import com.datingapp.game.data.entity.ParticipantFeatureEntity;

/**
 * Created on 01.05.2020
 *
 * @author onurcanyozgat
 */

@Converter
public class ParticipantFeatureConverter extends BaseConverter<ParticipantFeatureDto, ParticipantFeatureEntity> {
    @Override
    public ParticipantFeatureDto toDto(ParticipantFeatureEntity entity) {
        ParticipantFeatureDto dto = new ParticipantFeatureDto();
        dto.setFeatureData(entity.getFeature());
        dto.setParticipantFeature(entity.getParticipantFeature());
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public ParticipantFeatureEntity toEntity(ParticipantFeatureDto dto) {
        ParticipantFeatureEntity entity = new ParticipantFeatureEntity();
        entity.setFeature(dto.getFeatureData());
        entity.setParticipantFeature(dto.getParticipantFeature());
        entity.setId(dto.getId());
        return entity;
    }
}
