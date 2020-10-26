package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.SkillMatrix;

@Repository
public interface SkillMatrixRepo extends CrudRepository<SkillMatrix, Integer>{

	@SuppressWarnings("unchecked")
	public SkillMatrix save(SkillMatrix skillMatrix);
	
	public List<SkillMatrix> findAll();
	
	public SkillMatrix findById(int id);

}
