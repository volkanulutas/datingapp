package com.datingapp.user.repository;

import com.datingapp.user.data.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    List<User> findByIsDeleted(boolean isDeleted);

    User findByUsernameAndIsDeleted(String username, boolean isDeleted);
}
