package com.datingapp.chat.converter;

import com.datingapp.chat.data.dto.ChatDto;
import com.datingapp.chat.data.entity.Chat;
import org.springframework.stereotype.Component;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Component
public class ChatConverter extends BaseConverter<ChatDto, Chat> {

    @Override
    public ChatDto toDto(Chat source) {
        if (source == null) {
            return null;
        }
        ChatDto target = new ChatDto();
        target.setId(source.getId());
        target.setRoomName(source.getRoomName());
        target.setUsername(source.getUsername());
        target.setOtherUsername(source.getOtherUsername());
        target.setChatMessageList(source.getChatMessageList());
        return target;
    }

    @Override
    public Chat toEntity(ChatDto source) {
        if (source == null) {
            return null;
        }
        Chat target = new Chat();
        target.setId(source.getId());
        target.setRoomName(source.getRoomName());
        target.setUsername(source.getUsername());
        target.setOtherUsername(source.getOtherUsername());
        target.setChatMessageList(source.getChatMessageList());
        return target;
    }
}
