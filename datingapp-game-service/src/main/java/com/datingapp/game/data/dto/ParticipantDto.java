package com.datingapp.game.data.dto;

import java.util.List;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class ParticipantDto extends BaseDto {

    private String nickname;
    private List<ParticipantFeatureDto> participantFeatureList;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<ParticipantFeatureDto> getParticipantFeatureList() {
        return participantFeatureList;
    }

    public void setParticipantFeatureList(List<ParticipantFeatureDto> participantFeatureList) {
        this.participantFeatureList = participantFeatureList;
    }
}
