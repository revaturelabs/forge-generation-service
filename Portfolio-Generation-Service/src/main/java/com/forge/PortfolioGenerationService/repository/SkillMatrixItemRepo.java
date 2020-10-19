package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.SkillMatrixItem;

@Repository
public interface SkillMatrixItemRepo extends CrudRepository<SkillMatrixItem, Integer>{

	public SkillMatrixItem createSkillMatrixItem(SkillMatrixItem skillMatrixItem);
	
	public List<SkillMatrixItem> findAllSkillMatrixItem();
	
	public SkillMatrixItem findBySkillMatrixItemId(int id);
	
	public void updateSkillMatrixItem(SkillMatrixItem skillMatrixItem);
	
	public void deleteSkillMatrixItem(SkillMatrixItem skillMatrixItem);
	
}
