package com.forge.PortfolioGenerationService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.forge.PDFGenerationService.PDFGenerationServiceApplication;
import com.forge.PDFGenerationService.service.PortfolioService;

@SpringBootTest(classes= {PDFGenerationServiceApplication.class, PortfolioService.class})
public class PortfolioServiceTest {

	@Autowired
	PortfolioService portS;
	
//	@Test
//	public void ensurePortfolioGetsReturned() {
//		Assertions.assertNotNull(portS.getPortfolioById(1));
//	}
}
