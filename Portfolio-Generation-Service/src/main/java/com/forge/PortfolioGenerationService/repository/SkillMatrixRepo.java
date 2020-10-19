package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.SkillMatrix;

@Repository
public interface SkillMatrixRepo extends CrudRepository<SkillMatrix, Integer>{

	public SkillMatrix createSkillMatrix(SkillMatrix skillMatrix);
	
	public List<SkillMatrix> findAllSkillMatrix();
	
	public SkillMatrix findBySkillMatrixId(int id);
	
	public void updateSkillMatrix(SkillMatrix skillMatrix);
	
	public void deleteSkillMatrix(SkillMatrix skillMatrix);
}
