package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.ProjectTechnologies;

@Repository
public interface ProjectTechnologiesRepo extends CrudRepository<ProjectTechnologies, Integer>{

	@SuppressWarnings("unchecked")
	public ProjectTechnologies save(ProjectTechnologies projectTechnologies);
	
	public List<ProjectTechnologies> findAll();
	
	public ProjectTechnologies findById(int id);

}
