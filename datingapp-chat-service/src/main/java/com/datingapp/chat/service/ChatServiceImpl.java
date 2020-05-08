package com.datingapp.chat.service;

import com.datingapp.chat.converter.ChatConverter;
import com.datingapp.chat.converter.ChatMessageConverter;
import com.datingapp.chat.data.dto.ChatDto;
import com.datingapp.chat.data.dto.ChatMessageDto;
import com.datingapp.chat.data.dto.MatchUserDto;
import com.datingapp.chat.data.dto.UserDto;
import com.datingapp.chat.data.entity.Chat;
import com.datingapp.chat.data.entity.ChatMessage;
import com.datingapp.chat.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private ChatConverter chatConverter;

    @Autowired
    private ChatMessageConverter chatMessageConverter;

    public void handleMatchUser(MatchUserDto matchUserDto) {
        UserDto user = matchUserDto.getUser();
        List<UserDto> matchingList = matchUserDto.getMatchingList();

        for (UserDto otherUser : matchingList) {
            Chat chat = new Chat();
            String username = user.getUsername();
            chat.setUsername(username);
            chat.setOtherUsername(otherUser.getUsername());
            chat.setRoomName(generateRoomName(username, otherUser.getUsername()));
            saveData(chat);
        }
    }

    @Override
    public ChatDto findChatByRoomName(String roomName) {
        return chatConverter.toDto(findChatData(roomName));
    }

    @Override
    public List<ChatMessageDto> findChatHistory(String username, String otherUser) {
        List<ChatMessageDto> chatMessageDtoList = new ArrayList<>();
        String roomName = generateRoomName(username, otherUser);
        Chat chat = chatRepository.findByRoomName(roomName);
        for (ChatMessage chatMessage : chat.getChatMessageList()) {
            chatMessageDtoList.add(chatMessageConverter.toDto(chatMessage));
        }
        return chatMessageDtoList;
    }

    @Override
    public List<String> findUserChatUserList(String username) {
        List<String> otherUserList = new ArrayList<>();
        List<Chat> chatList = chatRepository.findByUsername(username);
        for (Chat chat : chatList) {
            otherUserList.add(chat.getOtherUsername());
        }
        return otherUserList;
    }

    @Override
    public boolean save(ChatDto chatParam) {
        return saveData(chatConverter.toEntity(chatParam));
    }

    @Override
    public void save(String roomName, ChatMessage chatMessage) {
        Chat chatByRoomName = findChatData(roomName);
        List<ChatMessage> chatMessageList = chatByRoomName.getChatMessageList();
        if (chatMessageList != null) {
            chatMessageList = new ArrayList<>();
        }
        chatMessage.setDate(System.currentTimeMillis()); // TODO: clientdan gelirse bunu sil.
        chatMessageList.add(chatMessage);
        chatByRoomName.setChatMessageList(chatMessageList);
        saveData(chatByRoomName);
    }

    private Chat findChatData(String roomName) {
        return chatRepository.findByRoomName(roomName);
    }

    private boolean saveData(Chat chatParam) {
        Chat result = null;
        Chat chat = findChatData(chatParam.getRoomName());
        if (chat != null) {
            chat.setUsername(chatParam.getUsername());
            chat.setOtherUsername(chatParam.getOtherUsername());
            chat.setRoomName(chatParam.getRoomName());
            chat.setDeleted(chatParam.isDeleted());
            chat.setChatMessageList(chatParam.getChatMessageList());
        } else {
            result = chatRepository.save(chatParam);
        }
        return result != null;
    }

    private String generateRoomName(String username, String otherUsername) {
        String roomDelim = "queue_";
        StringBuilder stringBuilder = new StringBuilder();
        int result = username.compareTo(otherUsername);
        if (result > 0) {
            stringBuilder.append(roomDelim).append(otherUsername).append("_").append(username).toString();
        } else {
            return stringBuilder.append(roomDelim).append(username).append("_").append(otherUsername).toString();
        }
        return null;
    }
}
