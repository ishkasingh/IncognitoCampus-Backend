package com.example.IncognitoCampus.Contoroller;



import com.example.IncognitoCampus.Models.ChatMessage;
import com.example.IncognitoCampus.Services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {



    @Autowired
    private ChatService chatMessageService;


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendMessage/{roomName}")
    // Client will send to /app/sendmessage
    // destvariable=pathvariable

    public void sendMessage(@DestinationVariable String roomName,@Payload ChatMessage chatMessage) {
        // Save to MongoDB
        chatMessage.setRoomName(roomName);
        ChatMessage saved = chatMessageService.save(chatMessage);

        // Broadcast to room subscribers
        messagingTemplate.convertAndSend("/topic/rooms/" + roomName, saved);
    }
}

