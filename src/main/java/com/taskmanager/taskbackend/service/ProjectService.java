package com.taskmanager.taskbackend.service;

import com.taskmanager.taskbackend.model.Project;
import com.taskmanager.taskbackend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(String id) {
        return projectRepository.findById(id);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }

    public Project updateProject(String id, Project updatedProject) {
        updatedProject.setId(id);
        return projectRepository.save(updatedProject);
    }
}
