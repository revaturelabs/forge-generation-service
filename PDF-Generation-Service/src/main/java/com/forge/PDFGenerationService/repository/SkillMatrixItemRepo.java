package com.forge.PDFGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PDFGenerationService.models.SkillMatrixItem;

@Repository
public interface SkillMatrixItemRepo extends CrudRepository<SkillMatrixItem, Integer>{

	@SuppressWarnings("unchecked")
	public SkillMatrixItem save(SkillMatrixItem skillMatrixItem);
	
	public List<SkillMatrixItem> findAll();
	
	public SkillMatrixItem findById(int id);
	
}
