package com.datingapp.game.data.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */
@Entity(name = "GAME_SESSION_ENTITY")
public class GameSessionEntity extends BaseEntity {

    @OneToMany(mappedBy = "")
    private List<FastQuestionEntity> questions;

    private long firstParticipantId;

    private long secondParticipantId;

    public List<FastQuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<FastQuestionEntity> questions) {
        this.questions = questions;
    }

    public long getFirstParticipantId() {
        return firstParticipantId;
    }

    public void setFirstParticipantId(long firstParticipantId) {
        this.firstParticipantId = firstParticipantId;
    }

    public long getSecondParticipantId() {
        return secondParticipantId;
    }

    public void setSecondParticipantId(long secondParticipantId) {
        this.secondParticipantId = secondParticipantId;
    }
}
