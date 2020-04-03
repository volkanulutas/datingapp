package com.datingapp.game.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created on 21.03.2020
 *
 * @author onurcanyozgat
 */

@Document("ParticipantFeature")
public class ParticipantFeatureEntity extends BaseEntity {

    private String feature;
    private long participantId;

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
