package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer>{

	
	public Project createProject(Project project);
	
	public List<Project> findAllProjects();
	
	public Project findByProjectId(int id);
	
	public void updateProject(Project project);
	
	public void deleteProject(Project project);
	
	
}
