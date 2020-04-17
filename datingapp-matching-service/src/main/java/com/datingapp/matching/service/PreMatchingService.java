package com.datingapp.matching.service;

import com.datingapp.matching.data.dto.PreMatchUserDto;
import org.springframework.stereotype.Service;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public interface PreMatchingService {
    PreMatchUserDto findPreMatchingByUsername(String username);
}
