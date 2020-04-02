package com.datingapp.game.service;

import com.datingapp.game.converter.GameSessionConverter;
import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.dto.GameSessionInitiateDto;
import com.datingapp.game.data.dto.QuestionAnsweredDto;
import com.datingapp.game.data.entity.AnswerEntity;
import com.datingapp.game.data.entity.FastQuestionEntity;
import com.datingapp.game.data.entity.GameSessionEntity;
import com.datingapp.game.repository.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */
@Service
public class GameSessionServiceImpl implements GameSessionService {

    @Autowired
    private FastQuestionService questionService;

    @Autowired
    private GameSessionRepository gameSessionRepository;

    @Autowired
    private GameSessionConverter gameSessionConverter;

    @Override
    public GameSessionDto initiateGameSession(GameSessionInitiateDto gameSessionInitiateDto) {
        GameSessionDto gameSessionDto = new GameSessionDto();
        gameSessionDto.setFirstParticipant(gameSessionInitiateDto.getFirstParticipant());
        gameSessionDto.setSecondParticipant(gameSessionInitiateDto.getSecondParticipant());
        gameSessionDto.setQuestions(questionService.getRandomQuestions(5));

        gameSessionRepository.save(gameSessionConverter.toEntity(gameSessionDto));
        return gameSessionDto;
    }

    @Override
    public boolean saveAnswer(QuestionAnsweredDto answer) {
        Optional<GameSessionEntity> gameSessionEntityOptional = gameSessionRepository.findById(answer.getGameSessionId());
        GameSessionEntity entity;
        if (gameSessionEntityOptional.isPresent()) {
            entity = gameSessionEntityOptional.get();
            for (FastQuestionEntity question : entity.getQuestions()) {
                if (question.getId().equals(answer.getQuestionId())) {
                    AnswerEntity answerEntity = new AnswerEntity();
                    answerEntity.setContent(answer.getContent());
                    answerEntity.setParticipantId(answer.getParticipantId());
                    if (entity.getFirstParticipant().getId().equals(answer.getParticipantId())) {
                        question.setFirstAnswer(answerEntity);
                    } else {
                        question.setSecondAnswer(answerEntity);
                    }
                    break;
                }
            }
            gameSessionRepository.save(entity);
        }
        return false;
    }

}
