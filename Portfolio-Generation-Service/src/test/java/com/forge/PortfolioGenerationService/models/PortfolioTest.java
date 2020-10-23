package com.forge.PortfolioGenerationService.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

	@Test
	public void testGetters() {
		Portfolio p = new Portfolio();
		p.setId(1);
		p.setBelongsTo("Anna");
		p.setStatus("pending");
		
		Assertions.assertEquals(1, p.getId());
		Assertions.assertEquals("Anna", p.getBelongsTo());
		Assertions.assertEquals("pending", p.getStatus());
	}
	
	
}
