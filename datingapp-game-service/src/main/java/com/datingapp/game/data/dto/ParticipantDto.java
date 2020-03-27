package com.datingapp.game.data.dto;

import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class ParticipantDto extends BaseDto {

    private Long id;
    private String nickname;
    private List<ParticipantFeatureDto> featureList;

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

    public List<ParticipantFeatureDto> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<ParticipantFeatureDto> featureList) {
        this.featureList = featureList;
    }
}
