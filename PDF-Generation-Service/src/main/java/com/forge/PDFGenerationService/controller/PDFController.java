package com.forge.PDFGenerationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PDFGenerationService.models.Portfolio;

import com.forge.PDFGenerationService.service.ITextPDFService;
import com.forge.PDFGenerationService.service.PortfolioService;
import com.forge.PDFGenerationService.service.S3FileService;

@RestController
@CrossOrigin
@RequestMapping("/pdf")
public class PDFController {

	
	@Autowired 
	private ITextPDFService iPortS;
	
	@Autowired
	private PortfolioService portS;
	
	@Autowired
	private S3FileService s3S;
	
	public PDFController(ITextPDFService iPortS, S3FileService s3S, PortfolioService portS) {
		this.s3S = s3S;
		this.iPortS = iPortS;
		this.portS = portS;
	}
	
	@GetMapping(value = "/getPDF/{username}/{id}", produces = "application/pdf")
	public byte[] getPDF(@PathVariable("username") String username, @PathVariable("id") int id) {
		return s3S.getFile("/", username, id); // PLEASE CONFIGURE WITH YOUR OWN BUCKET NAME.
		//ENSURE THAT LOCAL ENVIRONMENT HAS THE CREDENTIALS STORED IN ITS RESPECTIVE /HOME/.AWS FOLDER
	}
	
	@PostMapping("/storePDF/{id}")
	public void storePDF(@PathVariable("id") int id) {
		Portfolio p = portS.getPortfolioById(id);
		System.out.println("Portfolio id: " + p.getId() + " Portfolio Username: " + p.getMyUser().getEmail());
		s3S.upload("", p.getMyUser().getEmail(), id, iPortS.createITextPortfolioPDF(p));// PLEASE CONFIGURE WITH YOUR OWN BUCKET NAME.
		//ENSURE THAT LOCAL ENVIRONMENT HAS THE CREDENTIALS STORED IN ITS RESPECTIVE /HOME/.AWS FOLDER
	}



}
