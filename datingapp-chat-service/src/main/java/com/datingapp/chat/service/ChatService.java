package com.datingapp.chat.service;

import com.datingapp.chat.data.dto.ChatDto;
import com.datingapp.chat.data.dto.ChatMessageDto;
import com.datingapp.chat.data.dto.MatchUserDto;
import com.datingapp.chat.data.entity.ChatMessage;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
public interface ChatService {
    void handleMatchUser(MatchUserDto dto);

    ChatDto findChatByRoomName(String roomName);

    List<ChatMessageDto> findChatHistory(String username, String otherUser);

    List<String> findUserChatUserList(String username);

    boolean save(ChatDto chatParam);

    void save(String roomId, ChatMessage chatMessage);
}
