package com.datingapp.game.converter;

import com.datingapp.game.data.dto.ParticipantDto;
import com.datingapp.game.data.dto.ParticipantFeatureDto;
import com.datingapp.game.data.entity.ParticipantEntity;
import com.datingapp.game.data.entity.ParticipantFeatureEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

@Converter
public class ParticipantConverter extends BaseConverter<ParticipantDto, ParticipantEntity> {

    @Autowired
    private ParticipantFeatureConverter participantFeatureConverter;

    @Override
    public ParticipantDto toDto(ParticipantEntity entity) {
        ParticipantDto dto = new ParticipantDto();
        dto.setId(entity.getId());
        dto.setNickname(entity.getNickname());
        List<ParticipantFeatureDto> participantFeatureDtoList = entity.getParticipantFeatureList().stream().map(p -> participantFeatureConverter.toDto(p)).collect(Collectors.toList());
        dto.setParticipantFeatureList(participantFeatureDtoList);
        return dto;
    }

    @Override
    public ParticipantEntity toEntity(ParticipantDto dto) {
        ParticipantEntity entity = new ParticipantEntity();
        entity.setId(dto.getId());
        entity.setNickname(dto.getNickname());
        List<ParticipantFeatureEntity> participantFeatureEntityList = dto.getParticipantFeatureList().stream().map(p -> participantFeatureConverter.toEntity(p)).collect(Collectors.toList());
        entity.setParticipantFeatureList(participantFeatureEntityList);
        return entity;
    }
}
