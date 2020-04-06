package com.datingapp.game.converter;

import com.datingapp.game.data.dto.FastQuestionDto;
import com.datingapp.game.data.entity.FastQuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

@Converter
public class FastQuestionConverter extends BaseConverter<FastQuestionDto, FastQuestionEntity> {

    @Autowired
    private AnswerConverter answerConverter;

    @Override
    public FastQuestionDto toDto(FastQuestionEntity entity) {
        FastQuestionDto dto = new FastQuestionDto();
        dto.setQuestionContent(entity.getQuestionContent());
        if (entity.getFirstAnswer() != null) {
            dto.setFirstAnswer(answerConverter.toDto(entity.getFirstAnswer()));
        }
        if (entity.getSecondAnswer() != null) {
            dto.setSecondAnswer(answerConverter.toDto(entity.getSecondAnswer()));
        }
        return dto;
    }

    @Override
    public FastQuestionEntity toEntity(FastQuestionDto dto) {
        FastQuestionEntity entity = new FastQuestionEntity();
        entity.setQuestionContent(dto.getQuestionContent());
        if (dto.getFirstAnswer() != null) {
            entity.setFirstAnswer(answerConverter.toEntity(dto.getFirstAnswer()));
        }
        if (dto.getSecondAnswer() != null) {
            entity.setSecondAnswer(answerConverter.toEntity(dto.getSecondAnswer()));
        }
        return entity;
    }
}
