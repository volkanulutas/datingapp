package com.datingapp.chat.converter;

import com.datingapp.chat.data.dto.ChatMessageDto;
import com.datingapp.chat.data.entity.ChatMessage;
import org.springframework.stereotype.Component;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Component
public class ChatMessageConverter extends BaseConverter<ChatMessageDto, ChatMessage> {

    @Override
    public ChatMessageDto toDto(ChatMessage source) {
        if (source == null) {
            return null;
        }
        ChatMessageDto target = new ChatMessageDto();
        target.setContent(source.getContent());
        target.setDate(source.getDate());
        target.setId(source.getId());
        target.setReceiver(source.getReceiver());
        target.setType(source.getType());
        target.setSender(source.getSender());
        return target;
    }

    @Override
    public ChatMessage toEntity(ChatMessageDto source) {
        if (source == null) {
            return null;
        }
        ChatMessage target = new ChatMessage();
        target.setContent(source.getContent());
        target.setDate(source.getDate());
        target.setId(source.getId());
        target.setReceiver(source.getReceiver());
        target.setType(source.getType());
        target.setSender(source.getSender());
        return target;
    }
}
