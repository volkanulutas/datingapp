package com.datingapp.game.converter;

import com.datingapp.game.data.dto.AnswerDto;
import com.datingapp.game.data.entity.AnswerEntity;

/**
 * Created on 06.04.2020
 *
 * @author onurcanyozgat
 */
@Converter
public class AnswerConverter extends BaseConverter<AnswerDto, AnswerEntity> {

    @Override
    public AnswerDto toDto(AnswerEntity entity) {
        return null;
    }

    @Override
    public AnswerEntity toEntity(AnswerDto dto) {
        return null;
    }
}
