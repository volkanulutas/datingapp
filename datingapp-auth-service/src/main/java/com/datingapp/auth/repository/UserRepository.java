package com.datingapp.auth.repository;

import com.datingapp.auth.data.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserRepository extends MongoRepository<AppUser, String> {

    Optional<AppUser> findByUsername(String username);
}
