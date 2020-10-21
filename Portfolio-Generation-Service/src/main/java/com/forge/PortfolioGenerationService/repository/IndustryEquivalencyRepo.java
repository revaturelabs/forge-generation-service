package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.IndustryEquivalency;

@Repository
public interface IndustryEquivalencyRepo extends CrudRepository<IndustryEquivalency, Integer>{

	public IndustryEquivalency save(IndustryEquivalency industryEquivalency);
	
	public List<IndustryEquivalency> findAll();
	
	public IndustryEquivalency findById(int id);
}
