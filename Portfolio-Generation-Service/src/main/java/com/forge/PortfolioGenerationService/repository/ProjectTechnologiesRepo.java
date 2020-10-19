package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.ProjectTechnologies;

@Repository
public interface ProjectTechnologiesRepo extends CrudRepository<ProjectTechnologies, Integer>{

	public ProjectTechnologies createProjectTechnologies(ProjectTechnologies projectTechnologies);
	
	public List<ProjectTechnologies> findAllProjectTechnologies();
	
	public ProjectTechnologies findByProjectTechnologiesId(int id);
	
	public void updateProjectTechnologies(ProjectTechnologies projectTechnologies);
	
	public void deleteProjectTechnologies(ProjectTechnologies projectTechnologies);
}
