package com.forge.PDFGenerationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PDFGenerationService.models.User;
import com.forge.PDFGenerationService.service.ITextPDFService;

@RestController
@CrossOrigin
@RequestMapping("/pdf")
public class PDFController {

	
	@Autowired 
	private ITextPDFService iPortS;
	
	
	public PDFController(ITextPDFService iPortS) {

		this.iPortS = iPortS;
	}
	

	
	@PostMapping(value="/createUser")
	public void createUser(@RequestBody User user) {
		
	}
	
	@GetMapping(value = "/getItextPDF/{id}", produces = "application/pdf")
	public byte[] getITextPDF(@PathVariable("id") int id) {
		return iPortS.getPortfolioPDF(id);
	}


}
