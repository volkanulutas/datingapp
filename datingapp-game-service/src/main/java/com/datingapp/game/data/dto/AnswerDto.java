package com.datingapp.game.data.dto;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class AnswerDto extends BaseDto {

    private String content;
    private Long participantId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

}
