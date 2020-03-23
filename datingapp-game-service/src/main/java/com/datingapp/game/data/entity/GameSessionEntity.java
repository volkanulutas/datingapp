package com.datingapp.game.data.entity;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class GameSessionEntity {

    private long id;
    private long firstParticipantId;
    private long secondParticipantId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFirstParticipantId() {
        return firstParticipantId;
    }

    public void setFirstParticipantId(long firstParticipantId) {
        this.firstParticipantId = firstParticipantId;
    }

    public long getSecondParticipantId() {
        return secondParticipantId;
    }

    public void setSecondParticipantId(long secondParticipantId) {
        this.secondParticipantId = secondParticipantId;
    }
}
