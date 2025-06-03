package com.example.IncognitoCampus.Models;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document(collection = "messages")
public class ChatMessage {
    @Id
    private String id;

    private String roomId;
    private String senderName;
    private String senderId;
    private String roomName;  // anamous name

    private String collegeSnapshot;
    private String branchSnapshot;

    private String content;
    private Instant timestamp = Instant.now();
}

