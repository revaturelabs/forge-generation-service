package com.forge.PortfolioGenerationService.repository;

public interface EmailService {
	void send(String to, String title, String body);

}
