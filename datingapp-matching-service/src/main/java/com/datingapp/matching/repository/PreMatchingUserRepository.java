package com.datingapp.matching.repository;

import com.datingapp.matching.data.entity.PreMatchUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface PreMatchingUserRepository extends MongoRepository<PreMatchUser, String> {
    List<PreMatchUser> findByUser_Id(String userId);
}
