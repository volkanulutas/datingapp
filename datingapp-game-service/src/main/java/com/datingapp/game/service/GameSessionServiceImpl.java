package com.datingapp.game.service;

import com.datingapp.game.converter.GameSessionConverter;
import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.dto.GameSessionInitiateDto;
import com.datingapp.game.repository.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
