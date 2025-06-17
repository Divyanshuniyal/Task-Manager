package com.taskmanager.taskbackend.controller;

import com.taskmanager.taskbackend.model.Task;
import com.taskmanager.taskbackend.service.TaskService;
import com.taskmanager.taskbackend.websocket.TaskMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task);
        messagingTemplate.convertAndSend("/topic/tasks", new TaskMessage("Task Created", created.getTitle()));
        return created;
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task task) {
        Task updated = taskService.updateTask(id, task);
        messagingTemplate.convertAndSend("/topic/tasks", new TaskMessage("Task Updated", updated.getTitle()));
        return updated;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        taskService.deleteTask(id);
        if (task != null) {
            messagingTemplate.convertAndSend("/topic/tasks", new TaskMessage("Task Deleted", task.getTitle()));
        }
    }

    // 🔍 Search APIs
    @GetMapping("/search/title")
    public List<Task> searchByTitle(@RequestParam String title) {
        return taskService.searchByTitle(title);
    }

    @GetMapping("/search/status")
    public List<Task> searchByStatus(@RequestParam String status) {
        return taskService.searchByStatus(status);
    }

    @GetMapping("/search/user")
    public List<Task> searchByUser(@RequestParam String user) {
        return taskService.searchByAssignedUser(user);
    }
}
