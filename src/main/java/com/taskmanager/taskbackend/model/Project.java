package com.taskmanager.taskbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projects")
@Data
public class Project {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> assignedUsers; // usernames or user IDs
    private List<String> taskIds;       // IDs of tasks under this project
    private String startDate;
    private String dueDate;
    private String status;              // e.g., Not Started, In Progress, Completed
}
