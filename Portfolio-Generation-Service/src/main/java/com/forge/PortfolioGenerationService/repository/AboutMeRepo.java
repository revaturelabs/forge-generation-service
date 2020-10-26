package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.AboutMe;

@Repository
public interface AboutMeRepo extends CrudRepository<AboutMe, Integer>{

	@SuppressWarnings("unchecked")
	public AboutMe save(AboutMe aboutMe);
	
	public List<AboutMe> findAll();
	
	public AboutMe findById(int id);

}
