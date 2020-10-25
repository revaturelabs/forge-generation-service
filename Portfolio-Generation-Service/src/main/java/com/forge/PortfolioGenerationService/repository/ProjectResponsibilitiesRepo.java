package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.ProjectResponsibilities;

@Repository
public interface ProjectResponsibilitiesRepo extends CrudRepository<ProjectResponsibilities, Integer>{

	@SuppressWarnings("unchecked")
	public ProjectResponsibilities save(ProjectResponsibilities projectResponsibilities);
	
	public List<ProjectResponsibilities> findAll();
	
	public ProjectResponsibilities findById(int id);

}
