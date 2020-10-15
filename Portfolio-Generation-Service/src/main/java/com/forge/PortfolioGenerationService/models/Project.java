package com.forge.PortfolioGenerationService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	//PK
	private int id;
	private String name;
	private String description;
}
