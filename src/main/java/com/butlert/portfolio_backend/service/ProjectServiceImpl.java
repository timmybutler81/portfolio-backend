package com.butlert.portfolio_backend.service;

import com.butlert.portfolio_backend.model.Project;
import com.butlert.portfolio_backend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository repository;

    public ProjectServiceImpl(ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    @Override
    public Project createProject(Project project) {
        return repository.save(project);
    }
}
