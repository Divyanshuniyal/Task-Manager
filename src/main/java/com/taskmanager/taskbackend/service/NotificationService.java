package com.taskmanager.taskbackend.service;

import com.taskmanager.taskbackend.model.Notification;
import com.taskmanager.taskbackend.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification saveNotification(String type, String content, String taskId) {
        Notification notification = new Notification();
        notification.setType(type);
        notification.setContent(content);
        notification.setTaskId(taskId);
        notification.setTimestamp(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
