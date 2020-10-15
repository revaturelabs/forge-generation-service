package com.forge.PortfolioGenerationService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AboutMe {
	//PK
	private int id;
	private String description;
}
