package com.datingapp.game.service;

import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.dto.GameSessionInitiateDto;
import com.datingapp.game.data.dto.QuestionAnsweredDto;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */

public interface GameSessionService {

    GameSessionDto initiateGameSession(GameSessionInitiateDto gameSessionInitiateDto);

    boolean saveAnswer(QuestionAnsweredDto answer);
}
