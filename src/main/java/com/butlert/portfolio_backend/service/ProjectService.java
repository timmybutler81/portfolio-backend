package com.butlert.portfolio_backend.service;

import com.butlert.portfolio_backend.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {
    public List<Project> getAllProjects();
    public Project createProject(Project project);
    public Optional<Project> getProjectById(Long id);
}
