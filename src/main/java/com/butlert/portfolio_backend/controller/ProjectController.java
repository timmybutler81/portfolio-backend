package com.butlert.portfolio_backend.controller;

import com.butlert.portfolio_backend.model.Project;
import com.butlert.portfolio_backend.service.GitHubService;
import com.butlert.portfolio_backend.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final GitHubService gitHubService;

    public ProjectController(ProjectService projectService, GitHubService gitHubService) {
        this.projectService = projectService;
        this.gitHubService = gitHubService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping("/{id}/readme")
    public ResponseEntity<String> getReadme(@PathVariable Long id) {
        Project project = projectService.getProjectById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        String markdown = gitHubService.fetchReadme(project.getGithubLink());
        if (markdown == null) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body("README not found");
        }
        return ResponseEntity.ok(markdown);
    }


}
