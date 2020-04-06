package com.datingapp.game.data.dto;

/**
 * Created on 02.04.2020
 *
 * @author onurcanyozgat
 */

public class QuestionAnsweredDto extends BaseDto {

    private String gameSessionId;
    private String questionId;
    private String participantId;
    private String content;

    public String getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(String gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

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
