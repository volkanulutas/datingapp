package com.datingapp.game.controller;

import com.datingapp.game.data.dto.*;
import com.datingapp.game.service.GameSessionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */

@RestController
@RequestMapping(value = "/fastGame")
public class FastGameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastGameController.class);

    @Autowired
    private GameSessionServiceImpl gameSessionService;

    @PostMapping(value = "/initiateGameSession")
    public GameSessionDto initiateGameSession(@RequestBody GameSessionInitiateDto gameSessionInitiateDto) {
        GameSessionDto gameSessionDto = null;
        try {
            gameSessionDto = gameSessionService.initiateGameSession(gameSessionInitiateDto);
        } catch (Exception e) {
            LOGGER.error("An error occurred while instantiating game session : ", e);
        }
        return gameSessionDto;
    }

    @PostMapping(value = "/saveAnswer")
    public boolean saveAnswer(@RequestBody QuestionAnsweredDto questionAnsweredDto) {
        return gameSessionService.saveAnswer(questionAnsweredDto);
    }

    @PostMapping(value = "/saveScore")
    public boolean saveScore(@RequestBody AnswerScoredDto answerScoredDto) {
        return gameSessionService.saveScore(answerScoredDto);
    }

    @PostMapping(value = "/openParticipantFeature")
    public ParticipantFeatureDto getParticipantFeature(@RequestBody ParticipantFeatureRequestDto participantFeatureRequestDto) {
        return gameSessionService.getParticipantFeature(participantFeatureRequestDto);
    }

}
