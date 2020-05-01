package com.datingapp.game.service;

import com.datingapp.game.data.dto.*;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */

public interface GameSessionService {

    GameSessionDto initiateGameSession(GameSessionInitiateDto gameSessionInitiateDto);

    boolean saveAnswer(QuestionAnsweredDto answer);

    boolean saveScore(AnswerScoredDto score);

    ParticipantFeatureDto getParticipantFeature(ParticipantFeatureRequestDto participantFeature);
}
