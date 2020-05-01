package com.datingapp.game.service;

import com.datingapp.game.data.dto.ParticipantFeatureDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 01.05.2020
 *
 * @author onurcanyozgat
 */
@Service
public class ParticipantFeatureServiceImpl implements ParticipantFeatureService {

    @Override
    public ParticipantFeatureDto getParticipantFeature(List<ParticipantFeatureDto> participantFeatureDtoList, int score) {
        return participantFeatureDtoList.get(0);
    }
}
