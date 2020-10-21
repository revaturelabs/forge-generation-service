package com.forge.PortfolioGenerationService;




import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.forge.PortfolioGenerationService.repository.EmailServiceImpl;


@SpringBootTest
class EmailControllerTest {
	
	@Autowired
	private EmailServiceImpl esi;

	
	@BeforeEach
	void beforeTest() {
		System.out.println("Testing initialized.....");
	}
	
	@AfterEach
	void afterTest() {
		System.out.println("Testing completed.....");
	}
	
	@Test
	void testSendEmail() {
		esi.send("test@testing.com","Testing Method", "Test test test");
	}

}
