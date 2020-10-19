package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.Project;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer>{

	
	public Project save(Project project);
	
	public List<Project> findAll();
	
	public Project findById(int id);

	
	
}
