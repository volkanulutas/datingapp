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
    private List<ParticipantFeatureEntity> featureList;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<ParticipantFeatureEntity> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<ParticipantFeatureEntity> featureList) {
        this.featureList = featureList;
    }
}
