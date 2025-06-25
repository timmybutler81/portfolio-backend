package com.butlert.portfolio_backend.service;

import com.butlert.portfolio_backend.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    public List<Project> getAllProjects();
    public Project createProject(Project project);
}
