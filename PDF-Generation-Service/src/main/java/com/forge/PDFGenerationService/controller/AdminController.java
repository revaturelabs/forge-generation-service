package com.forge.PDFGenerationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PDFGenerationService.models.Portfolio;
import com.forge.PDFGenerationService.models.User;
import com.forge.PDFGenerationService.repository.PortfolioRepo;
import com.forge.PDFGenerationService.repository.UserRepo;

@RestController
@RequestMapping("/admin")
@CrossOrigin

public class AdminController {
	
	@Autowired
	private PortfolioRepo portfolioRepo;
	
	@Autowired
	private UserRepo userRepo;

	@GetMapping("/getAllPortfolios")
	public @ResponseBody List<Portfolio> getPortfolios(){
		List<Portfolio> myList = portfolioRepo.findAll();
		return myList;
	}
	
	
	@GetMapping("/getPortfoliosByStatus")
	public @ResponseBody List<Portfolio> getPortfoliosByStatus(String status){
		List<Portfolio> myList = portfolioRepo.findByStatus(status);
		return myList;
	}
	
	@GetMapping("/getAllUsers")
	public @ResponseBody List<User> getUsers(){
		return userRepo.findAll();
	}
	
	
}
