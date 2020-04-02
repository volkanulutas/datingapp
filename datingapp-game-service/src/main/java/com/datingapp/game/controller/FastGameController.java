package com.datingapp.game.controller;

import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.dto.GameSessionInitiateDto;
import com.datingapp.game.data.dto.QuestionAnsweredDto;
import com.datingapp.game.service.GameSessionServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */

@RestController
public class FastGameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastGameController.class);

    @Autowired
    private GameSessionServiceImpl gameSessionService;

    public GameSessionDto initiateGameSession(GameSessionInitiateDto gameSessionInitiateDto) {
        GameSessionDto gameSessionDto = null;
        try {
            gameSessionDto = gameSessionService.initiateGameSession(gameSessionInitiateDto);
        } catch (Exception e) {
            LOGGER.error("An error occurred while instantiating game session : ", e);
        }
        return gameSessionDto;
    }

    public boolean postAnswer(QuestionAnsweredDto questionAnsweredDto) {
        return gameSessionService.saveAnswer(questionAnsweredDto);
    }

}
