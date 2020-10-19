package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.ProjectResponsibilities;

@Repository
public interface ProjectResponsibilitiesRepo extends CrudRepository<ProjectResponsibilities, Integer>{

	public ProjectResponsibilities createProjectResponsibilities(ProjectResponsibilities projectResponsibilities);
	
	public List<ProjectResponsibilities> findAllProjectResponsibilities();
	
	public ProjectResponsibilities findByProjectResponsibilitiesId(int id);
	
	public void updateProjectResponsibilities(ProjectResponsibilities projectResponsibilities);
	
	public void deleteProjectResponsibilities(ProjectResponsibilities projectResponsibilities);
}
