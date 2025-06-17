package com.taskmanager.taskbackend.dto;

import com.taskmanager.taskbackend.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectProgressDTO {
    private String id;
    private String name;
    private String description;
    private String owner;
    private List<Task> tasks;
    private double completionPercentage;
}
