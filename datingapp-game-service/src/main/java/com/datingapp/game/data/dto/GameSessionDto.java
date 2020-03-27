package com.datingapp.game.data.dto;

import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class GameSessionDto extends BaseDto {

    private ParticipantDto firstParticipant;
    private ParticipantDto secondParticipant;
    private List<FastQuestionDto> questions;
    private ScoreDto score;

    public ParticipantDto getFirstParticipant() {
        return firstParticipant;
    }

    public void setFirstParticipant(ParticipantDto firstParticipant) {
        this.firstParticipant = firstParticipant;
    }

    public ParticipantDto getSecondParticipant() {
        return secondParticipant;
    }

    public void setSecondParticipant(ParticipantDto secondParticipant) {
        this.secondParticipant = secondParticipant;
    }

    public List<FastQuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<FastQuestionDto> questions) {
        this.questions = questions;
    }

    public ScoreDto getScore() {
        return score;
    }

    public void setScore(ScoreDto score) {
        this.score = score;
    }
}
