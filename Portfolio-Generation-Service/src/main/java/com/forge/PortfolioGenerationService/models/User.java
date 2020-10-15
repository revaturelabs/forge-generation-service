package com.forge.PortfolioGenerationService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	//primaryKey
	private String email;
	
	private String first_name;
	private String last_name;
}
