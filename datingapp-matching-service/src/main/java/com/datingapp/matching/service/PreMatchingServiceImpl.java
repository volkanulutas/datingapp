package com.datingapp.matching.service;

import com.datingapp.matching.converter.PreMatchUserConverter;
import com.datingapp.matching.data.dto.PreMatchUserDto;
import com.datingapp.matching.data.entity.PreMatchUser;
import com.datingapp.matching.repository.PreMatchingUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class PreMatchingServiceImpl implements PreMatchingService {

    @Autowired
    private PreMatchingUserRepository preMatchingUserRepository;

    @Autowired
    private PreMatchUserConverter preMatchConverter;

    @Override
    public PreMatchUserDto findPreMatchingByUserId(String userId) {
        AtomicReference<PreMatchUserDto> result = null;
        List<PreMatchUser> preMatchUserDtoList = preMatchingUserRepository.findByUser_Id(userId);
        Optional.of(preMatchUserDtoList).ifPresent(preMatchDtos -> {
            PreMatchUser preMatchUser = preMatchUserDtoList.get(0);
            result.set(preMatchConverter.toDto(preMatchUser));
        });
        return result.get();
    }
}
