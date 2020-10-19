package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.AboutMeItem;

@Repository
public interface AboutMeItemRepo extends CrudRepository<AboutMeItem, Integer>{

	public AboutMeItem createAboutMeItem(AboutMeItem aboutMeItem);
	
	public List<AboutMeItem> findAllAboutMeItem();
	
	public AboutMeItem findByAboutMeItemId(int id);
	
	public void updateAboutMeItem(AboutMeItem aboutMeItem);
	
	public void deleteAboutMeItem(AboutMeItem aboutMeItem);
}
