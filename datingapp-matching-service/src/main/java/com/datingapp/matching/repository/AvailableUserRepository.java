package com.datingapp.matching.repository;

import com.datingapp.matching.data.common.EnumUserGender;
import com.datingapp.matching.data.common.EnumUserStatus;
import com.datingapp.matching.data.dto.AvailableUserDto;
import com.datingapp.matching.data.entity.AvailableUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface AvailableUserRepository extends MongoRepository<AvailableUser, String> {
    AvailableUser findByUsername(String username);

    List<AvailableUserDto> findByGenderAndStatus(EnumUserGender gender, EnumUserStatus status);
}
