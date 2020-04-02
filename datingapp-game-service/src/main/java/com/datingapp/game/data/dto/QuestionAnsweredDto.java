package com.datingapp.game.data.dto;

/**
 * Created on 02.04.2020
 *
 * @author onurcanyozgat
 */

public class QuestionAnsweredDto {

    private Long gameSessionId;
    private Long questionId;
    private Long participantId;
    private String content;

    public Long getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(Long gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
