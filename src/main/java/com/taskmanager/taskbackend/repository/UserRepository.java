package com.taskmanager.taskbackend.repository;

import com.taskmanager.taskbackend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
