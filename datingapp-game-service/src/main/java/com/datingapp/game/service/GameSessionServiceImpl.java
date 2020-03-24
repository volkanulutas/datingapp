package com.datingapp.game.service;

import com.datingapp.game.data.dto.GameSessionDto;
import com.datingapp.game.data.dto.GameSessionInitiateDto;
import com.datingapp.game.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */
@Service
public class GameSessionServiceImpl implements GameSessionService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public GameSessionDto initiateGameSession(GameSessionInitiateDto gameSessionInitiateDto) {


        return null;
    }
}
