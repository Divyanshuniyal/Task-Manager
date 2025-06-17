package com.taskmanager.taskbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "team_members")
@Data
public class TeamMember {
    @Id
    private String id;
    private String name;
    private String email;
    private String role; // e.g., "Admin", "Developer", "Manager"
}
