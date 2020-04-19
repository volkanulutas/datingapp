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

    AvailableUser findByUsernameAndIsDeleted(String username, boolean isDeleted);

    List<AvailableUser> findByIsDeleted(boolean isDeleted);

    List<AvailableUserDto> findByGenderAndStatusAndIsDeleted(EnumUserGender gender,
                                                             EnumUserStatus online,
                                                             boolean isDeleted);
}
