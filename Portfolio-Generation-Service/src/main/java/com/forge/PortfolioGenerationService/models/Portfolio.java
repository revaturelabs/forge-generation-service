package com.forge.PortfolioGenerationService.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {
 
	//PK
	private int id;
	private String belongs_to;
	private String status;
}
