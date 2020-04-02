package com.datingapp.game.data.entity;

import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class ParticipantEntity extends BaseEntity {

    private Long id;
    private String nickname;
    private List<ParticipantFeatureEntity> featureList;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
