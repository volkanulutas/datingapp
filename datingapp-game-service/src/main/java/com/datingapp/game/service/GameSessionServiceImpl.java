package com.datingapp.game.service;

import com.datingapp.game.converter.GameSessionConverter;
import com.datingapp.game.converter.ParticipantFeatureConverter;
import com.datingapp.game.data.dto.*;
import com.datingapp.game.data.entity.AnswerEntity;
import com.datingapp.game.data.entity.FastQuestionEntity;
import com.datingapp.game.data.entity.GameSessionEntity;
import com.datingapp.game.data.entity.ParticipantFeatureEntity;
import com.datingapp.game.repository.GameSessionRepository;
import com.datingapp.game.service.feignInterface.ApiGatewayInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Autowired
    private ParticipantFeatureService participantFeatureService;

    @Autowired
    private ParticipantFeatureConverter participantFeatureConverter;

    private ApiGatewayInterface apiGatewayInterface;

    @Override
    public GameSessionDto initiateGameSession(GameSessionInitiateDto gameSessionInitiateDto) {
        GameSessionDto gameSessionDto = new GameSessionDto();
        gameSessionDto.setFirstParticipant(gameSessionInitiateDto.getFirstParticipant());
        gameSessionDto.setSecondParticipant(gameSessionInitiateDto.getSecondParticipant());
        gameSessionDto.setQuestions(questionService.getRandomQuestions(5));

        GameSessionEntity entity = gameSessionRepository.save(gameSessionConverter.toEntity(gameSessionDto));
        return gameSessionConverter.toDto(entity);
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
            GameSessionEntity gameSessionEntity = gameSessionRepository.save(entity);
            // diğer yarışmacı puan versin cevap gönderilmesi gerekli
            // TODO açılacak
//            apiGatewayInterface.sendAnswerToOtherParticipant(answer);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean saveScore(AnswerScoredDto score) {
        Optional<GameSessionEntity> gameSessionEntityOptional = gameSessionRepository.findById(score.getGameSessionId());
        GameSessionEntity entity;
        if (gameSessionEntityOptional.isPresent()) {
            entity = gameSessionEntityOptional.get();
            for (FastQuestionEntity question : entity.getQuestions()) {
                if (question.getId().equals(score.getQuestionId())) {
                    if (entity.getFirstParticipant().getId().equals(score.getParticipantId())) {
                        question.getFirstAnswer().setScore(score.getScore());
                    } else {
                        question.getSecondAnswer().setScore(score.getScore());
                    }
                    break;
                }
            }
            gameSessionRepository.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public ParticipantFeatureDto getParticipantFeature(ParticipantFeatureRequestDto participantFeature) {
        Optional<GameSessionEntity> gameSessionEntityOptional = gameSessionRepository.findById(participantFeature.getGameSessionId());
        GameSessionEntity entity;
        ParticipantFeatureDto participantFeatureDto;
        if (gameSessionEntityOptional.isPresent()) {
            entity = gameSessionEntityOptional.get();
            for (FastQuestionEntity question : entity.getQuestions()) {
                if (question.getId().equals(participantFeature.getQuestionId())) {
                    List<ParticipantFeatureEntity> participantFeatureList;
                    int score;
                    if (entity.getFirstParticipant().getId().equals(participantFeature.getParticipantId())) {
                        score = question.getFirstAnswer().getScore();
                        participantFeatureList = entity.getFirstParticipant().getParticipantFeatureList();
                    } else {
                        score = question.getSecondAnswer().getScore();
                        participantFeatureList = entity.getSecondParticipant().getParticipantFeatureList();
                    }
                    List<ParticipantFeatureDto> participantFeatureDtoList = participantFeatureList.stream().map(p -> participantFeatureConverter.toDto(p)).collect(Collectors.toList());
                    participantFeatureDto = participantFeatureService.getParticipantFeature(participantFeatureDtoList, score);
                    return participantFeatureDto;
                }
            }
        }
        return null;
    }
}