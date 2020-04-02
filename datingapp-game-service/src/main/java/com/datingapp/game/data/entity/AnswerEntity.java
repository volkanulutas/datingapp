package com.datingapp.game.data.entity;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class AnswerEntity {

    private long participantId;
    private String content;

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
