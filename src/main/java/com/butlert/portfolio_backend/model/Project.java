package com.butlert.portfolio_backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String projectTitle;

    @Column(name = "description")
    private String projectDescription;

    @Column(name = "github_link")
    private String githubLink;

    @Column(name = "live_demo_link")
    private String liveDemoLink;

    @ManyToMany
    @JoinTable(
            name = "project_tags",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonManagedReference
    private Set<Tag> tags;

    public Project() {
    }

    public Project(Long id, String projectTitle, String projectDescription, String githubLink, String liveDemoLink, Set<Tag> tags) {
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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectTitle='" + projectTitle + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", githubLink='" + githubLink + '\'' +
                ", liveDemoLink='" + liveDemoLink + '\'' +
                ", tags=" + tags +
                '}';
    }
}