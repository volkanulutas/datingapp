package com.datingapp.chat.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String receiver;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }
}
