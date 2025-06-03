package com.example.IncognitoCampus.Contoroller;

import com.example.IncognitoCampus.Models.ChatMessage;
import com.example.IncognitoCampus.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "http://localhost:5173") // Optional if you have global config
public class MessageController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/room/{roomName}")
    public List<ChatMessage> getMessagesByRoomName(@PathVariable String roomName) {
        return chatService.getMessagesByRoomName(roomName);
    }
}

