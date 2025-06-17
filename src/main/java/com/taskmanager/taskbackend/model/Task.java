package com.taskmanager.taskbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("description")
    private String description;

    @Field("status")
    private String status; // e.g., "To Do", "In Progress", "Completed"

    @Field("priority")
    private String priority; // e.g., "Low", "Medium", "High"

    @Field("dueDate")
    private LocalDateTime dueDate;

    @Field("assignedUser")
    private String assignedUser; // user ID or name

    @Field("projectId")
    private String projectId; // if tasks are grouped by project

    @Field("createdAt")
    private LocalDateTime createdAt;

    @Field("updatedAt")
    private LocalDateTime updatedAt;

    @Field("createdBy")
    private String createdBy;

    // Optional: You can manually define getters if you're not using Lombok
    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    // You can add more fields here like attachments, comments, etc.
}
