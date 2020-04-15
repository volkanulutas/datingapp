package com.datingapp.auth.repository;

import com.datingapp.auth.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
