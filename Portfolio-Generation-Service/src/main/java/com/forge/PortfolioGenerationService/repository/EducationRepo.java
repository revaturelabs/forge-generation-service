package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.Education;

@Repository
public interface EducationRepo extends CrudRepository<Education, Integer>{

	public Education save(Education education);
	
	public List<Education> findAll();
	
	public Education findById(int id);

}
