package com.datingapp.game.data.entity;

import com.datingapp.game.data.dto.EnumParticipantFeature;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

@Document("ParticipantFeature")
public class ParticipantFeatureEntity extends BaseEntity {

    private EnumParticipantFeature participantFeature;
    private String feature;
    private long participantId;

    public EnumParticipantFeature getParticipantFeature() {
        return participantFeature;
    }

    public void setParticipantFeature(EnumParticipantFeature participantFeature) {
        this.participantFeature = participantFeature;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }
}
