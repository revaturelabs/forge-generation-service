package com.forge.PortfolioGenerationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PortfolioGenerationService.models.Portfolio;
import com.forge.PortfolioGenerationService.repository.PortfolioRepo;

@RestController
@RequestMapping("/admin")
@CrossOrigin

public class AdminController {
	
	@Autowired
	private PortfolioRepo portfolioRepo;

	@GetMapping("/getAllPortfolios")
	public @ResponseBody List<Portfolio> getPortfolios(){
		return portfolioRepo.findAll();
	}
}
