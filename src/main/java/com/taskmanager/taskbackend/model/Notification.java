package com.taskmanager.taskbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private String type;          // e.g., "Task Created", "Task Deleted"
    private String content;       // e.g., "Task X was created"
    private String taskId;        // Optional: task related to notification
    private LocalDateTime timestamp;
}
