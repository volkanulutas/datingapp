package com.datingapp.game.data.dto;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class AnswerDto {

    private String answerContent;
    private ParticipantDto participantDto;

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public ParticipantDto getParticipantDto() {
        return participantDto;
    }

    public void setParticipantDto(ParticipantDto participantDto) {
        this.participantDto = participantDto;
    }
}
