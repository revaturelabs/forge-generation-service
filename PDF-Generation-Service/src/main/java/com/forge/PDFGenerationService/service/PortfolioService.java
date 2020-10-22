package com.forge.PDFGenerationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forge.PDFGenerationService.models.Portfolio;
import com.forge.PDFGenerationService.repository.PortfolioRepo;

@Service
public class PortfolioService {

	@Autowired
	private PortfolioRepo portR;
	
	public PortfolioService(PortfolioRepo portR) {
		this.portR=portR;
	}
	
	public Portfolio getPortfolioById(int id) {
		return portR.findById(id);
	}
}
