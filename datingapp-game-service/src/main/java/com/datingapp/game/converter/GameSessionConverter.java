package com.datingapp.game.converter;

import com.datingapp.game.data.dto.FastQuestionDto;
import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.entity.FastQuestionEntity;
import com.datingapp.game.data.entity.GameSessionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

@Converter
public class GameSessionConverter extends BaseConverter<GameSessionDto, GameSessionEntity> {

    @Autowired
    private FastQuestionConverter questionConverter;

    @Autowired
    private ParticipantConverter participantConverter;

    @Override
    public GameSessionDto toDto(GameSessionEntity entity) {
        GameSessionDto dto = new GameSessionDto();
        dto.setId(entity.getId());
        dto.setFirstParticipant(participantConverter.toDto(entity.getFirstParticipant()));
        dto.setSecondParticipant(participantConverter.toDto(entity.getSecondParticipant()));
        List<FastQuestionDto> questionDtoList = new ArrayList<>();
        for (FastQuestionEntity question : entity.getQuestions()) {
            questionDtoList.add(questionConverter.toDto(question));
        }
        dto.setQuestions(questionDtoList);
        return dto;
    }

    @Override
    public GameSessionEntity toEntity(GameSessionDto dto) {
        GameSessionEntity entity = new GameSessionEntity();
        entity.setId(dto.getId());
        entity.setFirstParticipant(participantConverter.toEntity(dto.getFirstParticipant()));
        entity.setSecondParticipant(participantConverter.toEntity(dto.getSecondParticipant()));
        List<FastQuestionEntity> questionEntities = new ArrayList<>();
        for (FastQuestionDto question : dto.getQuestions()) {
            questionEntities.add(questionConverter.toEntity(question));
        }
        entity.setQuestions(questionEntities);
        return entity;
    }

}
