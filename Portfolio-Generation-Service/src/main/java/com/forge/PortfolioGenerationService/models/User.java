package com.forge.PortfolioGenerationService.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Entity
@Table(name = "User_Table")
public class User {
	
	@Id
	@Column(name = "User_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int UserId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name", nullable = false)
	private String first_name;
	
	@Column(name = "last_name", nullable = false)
	private String last_name;
	
//	@OneToOne(mappedBy = "portfolio")
//	private Portfolio portfolio;

	




	
	

}
