package com.datingapp.game.converter;

import com.datingapp.game.data.dto.FastQuestionDto;
import com.datingapp.game.data.entity.FastQuestionEntity;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

@Converter
public class FastQuestionConverter extends BaseConverter<FastQuestionDto, FastQuestionEntity> {

    @Override
    public FastQuestionDto toDto(FastQuestionEntity entity) {
        return null;
    }

    @Override
    public FastQuestionEntity toEntity(FastQuestionDto dto) {
        return null;
    }
}
