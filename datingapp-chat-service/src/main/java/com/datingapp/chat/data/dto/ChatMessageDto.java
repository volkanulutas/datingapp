package com.datingapp.chat.data.dto;

import com.datingapp.chat.data.common.EnumMessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 533962579272886650L;

    private String id;
    private EnumMessageType type;
    private String content;
    private String sender;
    private String receiver;
    private long date;
}
