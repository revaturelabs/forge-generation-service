package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.Portfolio;

@Repository
public interface PortfolioRepo extends CrudRepository<Portfolio, Integer>{

	public Portfolio createPortfolio(Portfolio portfolio);
	
	public List<Portfolio> findAllPortfolios();
	
	public Portfolio findByPortfolioId(int id);
	
	public void updatePortfolio(Portfolio portfolio);
	
	public void deletePortfolio(Portfolio portfolio);
}
