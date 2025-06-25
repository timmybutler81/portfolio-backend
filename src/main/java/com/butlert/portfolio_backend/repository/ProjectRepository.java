package com.butlert.portfolio_backend.repository;

import com.butlert.portfolio_backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
