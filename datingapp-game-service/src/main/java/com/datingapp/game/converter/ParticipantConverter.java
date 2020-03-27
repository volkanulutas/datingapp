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
        return null;
    }

    @Override
    public ParticipantEntity toEntity(ParticipantDto dto) {
        return null;
    }
}
