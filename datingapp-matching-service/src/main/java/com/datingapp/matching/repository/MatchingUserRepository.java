package com.datingapp.matching.repository;

import com.datingapp.matching.data.entity.MatchUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface MatchingUserRepository extends MongoRepository<MatchUser, String> {
    List<MatchUser> findByUser_Id(String userId);
}
