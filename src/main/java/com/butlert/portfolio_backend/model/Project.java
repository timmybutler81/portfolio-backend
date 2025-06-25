package com.butlert.portfolio_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectTitle;
    private String projectDescription;
    private String githubLink;
    private String liveDemoLink;

    @ElementCollection
    private List<String> tags;

    public Project() {

    }

    public Project(Long id, String projectTitle, String projectDescription, String githubLink, String liveDemoLink, List<String> tags) {
        this.id = id;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.githubLink = githubLink;
        this.liveDemoLink = liveDemoLink;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLiveDemoLink() {
        return liveDemoLink;
    }

    public void setLiveDemoLink(String liveDemoLink) {
        this.liveDemoLink = liveDemoLink;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
