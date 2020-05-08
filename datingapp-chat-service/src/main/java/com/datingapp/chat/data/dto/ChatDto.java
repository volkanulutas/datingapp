package com.datingapp.chat.data.dto;

import com.datingapp.chat.data.entity.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Created on 30.03.2020
 *
 * @author volkanulutas
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatDto extends BaseDto {

    private String id;

    private String roomName;

    private String username;

    private String otherUsername;

    private List<ChatMessage> chatMessageList;
}
