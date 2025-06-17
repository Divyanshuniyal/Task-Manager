package com.taskmanager.taskbackend.service;

import com.taskmanager.taskbackend.model.Task;
import com.taskmanager.taskbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(String id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setAssignedUser(updatedTask.getAssignedUser());
            return taskRepository.save(existingTask);
        }
        return null;
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    // 🔍 Search Functions
    public List<Task> searchByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Task> searchByStatus(String status) {
        return taskRepository.findByStatusIgnoreCase(status);
    }

    public List<Task> searchByAssignedUser(String user) {
        return taskRepository.findByAssignedUserIgnoreCase(user);
    }
}
