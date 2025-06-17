package com.taskmanager.taskbackend.repository;

import com.taskmanager.taskbackend.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByStatusIgnoreCase(String status);
    List<Task> findByAssignedUserIgnoreCase(String assignedUser);
}
