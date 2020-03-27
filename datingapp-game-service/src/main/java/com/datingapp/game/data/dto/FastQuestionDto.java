package com.datingapp.game.data.dto;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class FastQuestionDto extends BaseDto {

    private String questionContent;
    private AnswerDto firstAnswer;
    private AnswerDto secondAnswer;

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public AnswerDto getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(AnswerDto firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public AnswerDto getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(AnswerDto secondAnswer) {
        this.secondAnswer = secondAnswer;
    }
}
