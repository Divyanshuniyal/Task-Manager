package com.taskmanager.taskbackend.repository;

import com.taskmanager.taskbackend.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
