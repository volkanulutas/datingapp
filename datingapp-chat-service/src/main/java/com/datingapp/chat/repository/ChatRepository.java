package com.datingapp.chat.repository;

import com.datingapp.chat.data.entity.Chat;
import com.datingapp.chat.data.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface ChatRepository extends MongoRepository<Chat, String> {
    Chat findByRoomName(String roomName);

    List<Chat> findByUsername(String username);
}
