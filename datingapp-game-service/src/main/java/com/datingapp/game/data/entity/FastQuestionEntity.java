package com.datingapp.game.data.entity;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class FastQuestionEntity extends BaseEntity {

    private Long id;
    private String questionContent;
    private AnswerEntity firstAnswer;
    private AnswerEntity secondAnswer;

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public AnswerEntity getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(AnswerEntity firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public AnswerEntity getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(AnswerEntity secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
