package com.forge.PortfolioGenerationService.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

	//PK
	private int id;
	private String university;
	private Date graduation;
	private String major;
	private String minor; 
}
