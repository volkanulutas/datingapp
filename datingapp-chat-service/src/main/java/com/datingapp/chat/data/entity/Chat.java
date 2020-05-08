package com.datingapp.chat.data.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "Chat")
public class Chat extends BaseEntity implements Serializable {

    @Indexed(unique = true)
    private String roomName;

    private String username;

    private String otherUsername;

    private List<ChatMessage> chatMessageList;
}
