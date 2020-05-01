package com.datingapp.game.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

@Document("Participant")
public class ParticipantEntity extends BaseEntity {

    private String nickname;
    private List<ParticipantFeatureEntity> participantFeatureList;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<ParticipantFeatureEntity> getParticipantFeatureList() {
        return participantFeatureList;
    }

    public void setParticipantFeatureList(List<ParticipantFeatureEntity> participantFeatureList) {
        this.participantFeatureList = participantFeatureList;
    }
}
