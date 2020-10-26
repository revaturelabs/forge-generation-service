package com.forge.PDFGenerationService.repository;	

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PDFGenerationService.models.Portfolio;

@Repository
public interface PortfolioRepo extends CrudRepository<Portfolio, Integer>{

	@SuppressWarnings("unchecked")
	public Portfolio save(Portfolio portfolio);

	public List<Portfolio> findAll();
	
	public Portfolio findById(int id);
	
	public List<Portfolio> findByStatus(String status);

}
