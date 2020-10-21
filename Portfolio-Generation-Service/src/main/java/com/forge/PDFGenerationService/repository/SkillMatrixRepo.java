package com.forge.PDFGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PDFGenerationService.models.SkillMatrix;

@Repository
public interface SkillMatrixRepo extends CrudRepository<SkillMatrix, Integer>{

	public SkillMatrix save(SkillMatrix skillMatrix);
	
	public List<SkillMatrix> findAll();
	
	public SkillMatrix findById(int id);

}
