package com.taskmanager.taskbackend.repository;

import com.taskmanager.taskbackend.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
