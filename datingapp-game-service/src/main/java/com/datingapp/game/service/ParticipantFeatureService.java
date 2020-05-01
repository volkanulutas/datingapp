package com.datingapp.game.service;

import com.datingapp.game.data.dto.ParticipantFeatureDto;

import java.util.List;

/**
 * Created on 01.05.2020
 *
 * @author onurcanyozgat
 */

public interface ParticipantFeatureService {

    ParticipantFeatureDto getParticipantFeature(List<ParticipantFeatureDto> participantFeatureDtoList, int score);

}
