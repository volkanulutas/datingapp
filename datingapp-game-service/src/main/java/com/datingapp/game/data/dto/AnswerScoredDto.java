package com.datingapp.game.data.dto;

/**
 * Created on 01.05.2020
 *
 * @author onurcanyozgat
 */

public class AnswerScoredDto extends QuestionActionDto {

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
