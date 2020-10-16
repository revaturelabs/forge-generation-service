package com.forge.PortfolioGenerationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forge.PortfolioGenerationService.models.Project;

public interface ProjectRepository extends JpaRepository<Project , Integer> {
}
