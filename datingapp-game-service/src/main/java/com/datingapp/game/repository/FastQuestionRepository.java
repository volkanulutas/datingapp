package com.datingapp.game.repository;

import com.datingapp.game.data.entity.FastQuestionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
 */
@Repository
public interface FastQuestionRepository extends MongoRepository<FastQuestionEntity, Long> {
}
