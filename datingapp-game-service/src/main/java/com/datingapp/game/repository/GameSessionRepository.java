package com.datingapp.game.repository;

import com.datingapp.game.data.entity.GameSessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 24.03.2020
 *
 * @author onurcanyozgat
 */
@Repository
public interface GameSessionRepository extends MongoRepository<GameSessionEntity, Long> {
}
