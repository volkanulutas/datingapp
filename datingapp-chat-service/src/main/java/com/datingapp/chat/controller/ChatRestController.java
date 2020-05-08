package com.datingapp.chat.controller;


import com.datingapp.chat.data.dto.ChatMessageDto;
import com.datingapp.chat.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@RestController
@Slf4j
public class ChatRestController {
    @Autowired
    private ChatService chatService;

    @GetMapping(value = "/history", produces = "application/json")
    public ResponseEntity<List<ChatMessageDto>> findChatHistory(@RequestParam String username,
                                                                @RequestParam String otherUser) {
        List<ChatMessageDto> chatHistory = chatService.findChatHistory(username, otherUser);
        return (chatHistory.isEmpty()) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(chatHistory, HttpStatus.OK);
    }

    @GetMapping(value = "/friendList")
    public ResponseEntity<List<String>> findUserChatUserList(@RequestParam String username) {
        List<String> friendList = chatService.findUserChatUserList(username);
        return (friendList.isEmpty()) ? new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)
                : new ResponseEntity<>(friendList, HttpStatus.OK);
    }


}
