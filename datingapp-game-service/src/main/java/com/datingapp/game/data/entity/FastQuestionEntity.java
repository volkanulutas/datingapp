package com.datingapp.game.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

@Document("FastQuestion")
public class FastQuestionEntity extends BaseEntity {

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

}
