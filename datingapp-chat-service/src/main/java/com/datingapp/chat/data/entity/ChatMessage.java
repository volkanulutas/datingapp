package com.datingapp.chat.data.entity;

import com.datingapp.chat.data.common.EnumMessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage extends BaseEntity {
    private EnumMessageType type;
    private String content;
    private String sender;
    private String receiver;
    private long date;
}
