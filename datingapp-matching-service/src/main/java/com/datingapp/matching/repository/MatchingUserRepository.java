package com.datingapp.matching.repository;

import com.datingapp.matching.data.entity.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface MatchingUserRepository extends MongoRepository<Match, String> {

}
