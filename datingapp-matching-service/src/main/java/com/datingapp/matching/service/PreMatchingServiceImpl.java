package com.datingapp.matching.service;

import com.datingapp.matching.data.dto.PreMatchUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class PreMatchingServiceImpl implements PreMatchingService {

    @Autowired
    private PreMatchingCriteriaService preMatchingCriteriaService;

    @Override
    public PreMatchUserDto findPreMatchingByUsername(String username) {
        // TODO: önceden önerilmiş prematch önermeme.
        PreMatchUserDto preMatchingUserByCriteria = preMatchingCriteriaService.getPreMatchingUserByCriteria(username);
        return preMatchingUserByCriteria;
    }
}
