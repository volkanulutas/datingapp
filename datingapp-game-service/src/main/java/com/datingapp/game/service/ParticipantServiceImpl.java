package com.datingapp.game.service;

import com.datingapp.game.converter.ParticipantConverter;
import com.datingapp.game.data.dto.ParticipantDto;
import com.datingapp.game.data.entity.ParticipantEntity;
import com.datingapp.game.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository repository;

    @Autowired
    private ParticipantConverter participantConverter;

    @Override
    public ParticipantDto findById(Long id) {
        Optional<ParticipantEntity> optional = repository.findById(id);
        return optional.map(participantEntity -> participantConverter.toDto(participantEntity)).orElse(null);
    }
}
