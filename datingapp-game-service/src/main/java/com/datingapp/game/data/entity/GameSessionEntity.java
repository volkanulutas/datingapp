package com.datingapp.game.data.entity;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */
@Entity(name = "GAME_SESSION_ENTITY")
public class GameSessionEntity extends BaseEntity {

    private ParticipantEntity firstParticipant;
    private ParticipantEntity secondParticipant;
    private List<FastQuestionEntity> questions;
    private ScoreEntity score;

    public ParticipantEntity getFirstParticipant() {
        return firstParticipant;
    }

    public void setFirstParticipant(ParticipantEntity firstParticipant) {
        this.firstParticipant = firstParticipant;
    }

    public ParticipantEntity getSecondParticipant() {
        return secondParticipant;
    }

    public void setSecondParticipant(ParticipantEntity secondParticipant) {
        this.secondParticipant = secondParticipant;
    }

    public List<FastQuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<FastQuestionEntity> questions) {
        this.questions = questions;
    }

    public ScoreEntity getScore() {
        return score;
    }

    public void setScore(ScoreEntity score) {
        this.score = score;
    }
}
