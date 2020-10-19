package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.Education;

@Repository
public interface EducationRepo extends CrudRepository<Education, Integer>{

	public Education createEducation(Education education);
	
	public List<Education> findAllEducation();
	
	public Education findByEducationId(int id);
	
	public void updateEducation(Education education);
	
	public void deleteEducation(Education education);
}
