package com.datingapp.game.converter;

import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.dto.FastQuestionDto;
import com.datingapp.game.data.entity.GameSessionEntity;
import com.datingapp.game.data.entity.FastQuestionEntity;
import com.datingapp.game.service.FastQuestionService;
import com.datingapp.game.service.ParticipantService;
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
    private ParticipantService participantService;

    @Autowired
    private FastQuestionService questionService;

    @Autowired
    private FastQuestionConverter questionConverter;

    @Override
    public GameSessionDto toDto(GameSessionEntity entity) {
        GameSessionDto dto = new GameSessionDto();
        dto.setFirstParticipant(participantService.findById(entity.getFirstParticipantId()));
        dto.setSecondParticipant(participantService.findById(entity.getSecondParticipantId()));
        List<FastQuestionDto> questionDtoList = new ArrayList<>();
        for (FastQuestionEntity question : entity.getQuestions()) {
            questionDtoList.add(questionService.findById(question.getId()));
        }
        dto.setQuestions(questionDtoList);
        return dto;
    }

    @Override
    public GameSessionEntity toEntity(GameSessionDto dto) {
        GameSessionEntity entity = new GameSessionEntity();
        entity.setFirstParticipantId(dto.getFirstParticipant().getId());
        entity.setSecondParticipantId(dto.getSecondParticipant().getId());
        List<FastQuestionEntity> questionEntities = new ArrayList<>();
        for (FastQuestionDto question : dto.getQuestions()) {
            questionEntities.add(questionConverter.toEntity(question));
        }
        entity.setQuestions(questionEntities);
        return entity;
    }

}
