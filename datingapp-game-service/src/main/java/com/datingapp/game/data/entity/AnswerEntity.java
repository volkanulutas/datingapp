package com.datingapp.game.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

@Document("Answer")
public class AnswerEntity extends BaseEntity {

    private String participantId;
    private String content;

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
