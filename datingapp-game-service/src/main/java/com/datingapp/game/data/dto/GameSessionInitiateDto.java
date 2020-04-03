package com.datingapp.game.data.dto;

import com.datingapp.game.data.EnumGameType;

import java.io.Serializable;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */

public class GameSessionInitiateDto implements Serializable {

    private EnumGameType gameType;
    private ParticipantDto firstParticipant;
    private ParticipantDto secondParticipant;

    public EnumGameType getGameType() {
        return gameType;
    }

    public void setGameType(EnumGameType gameType) {
        this.gameType = gameType;
    }

    public ParticipantDto getFirstParticipant() {
        return firstParticipant;
    }

    public void setFirstParticipant(ParticipantDto firstParticipant) {
        this.firstParticipant = firstParticipant;
    }

    public ParticipantDto getSecondParticipant() {
        return secondParticipant;
    }

    public void setSecondParticipant(ParticipantDto secondParticipant) {
        this.secondParticipant = secondParticipant;
    }
}
