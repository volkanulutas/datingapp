package com.datingapp.game.service;

import com.datingapp.game.data.dto.ParticipantDto;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

public interface ParticipantService {

    ParticipantDto findById(Long id);

}
