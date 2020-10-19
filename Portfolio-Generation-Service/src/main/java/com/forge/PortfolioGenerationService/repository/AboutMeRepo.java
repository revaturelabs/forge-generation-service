package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.AboutMe;

@Repository
public interface AboutMeRepo extends CrudRepository<AboutMeRepo, Integer>{

	public AboutMe createAboutMe(AboutMe aboutMe);
	
	public List<AboutMe> findAllAboutMe();
	
	public AboutMe findByAboutMeId(int id);
	
	public void updateAboutMe(AboutMe aboutMe);
	
	public void deleteAboutMe(AboutMe aboutMe);
}
