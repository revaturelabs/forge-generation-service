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
<<<<<<< HEAD
@Table(name = "User_Table")
=======
@Table(name = "users")
>>>>>>> 78e4e31e13220c0b7d5bf75b15b32f6910355ac0
public class User {

	@Id
<<<<<<< HEAD
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

	




	
	

=======
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
>>>>>>> 78e4e31e13220c0b7d5bf75b15b32f6910355ac0
}
