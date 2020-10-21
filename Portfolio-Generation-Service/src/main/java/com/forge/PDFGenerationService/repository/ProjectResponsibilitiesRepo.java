package com.forge.PDFGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PDFGenerationService.models.ProjectResponsibilities;

@Repository
public interface ProjectResponsibilitiesRepo extends CrudRepository<ProjectResponsibilities, Integer>{

	public ProjectResponsibilities save(ProjectResponsibilities projectResponsibilities);
	
	public List<ProjectResponsibilities> findAll();
	
	public ProjectResponsibilities findById(int id);

}
