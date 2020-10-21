package com.forge.PortfolioGenerationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PortfolioGenerationService.repository.EmailServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/admin")
public class EmailController {
	
	@Autowired
	private EmailServiceImpl esi;
	

	@GetMapping(value="/sendEmail")
	@ApiOperation(value="Sending an email to the respected person",
				  notes = "Sending an email to inform the person of thier porfolio status")
	public String sendEmail() {
		esi.send("test@revature.net", "Test email subject", "test email body");
		return "sent";
	}
}
