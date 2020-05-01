package com.datingapp.game.data.dto;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

public class ParticipantFeatureDto extends BaseDto {

    private EnumParticipantFeature participantFeature;

    private String featureData;

    public EnumParticipantFeature getParticipantFeature() {
        return participantFeature;
    }

    public void setParticipantFeature(EnumParticipantFeature participantFeature) {
        this.participantFeature = participantFeature;
    }

    public String getFeatureData() {
        return featureData;
    }

    public void setFeatureData(String featureData) {
        this.featureData = featureData;
    }
}
