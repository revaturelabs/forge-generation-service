package com.forge.PortfolioGenerationService.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolio")
public class Portfolio {
 
	@Id
	@Column(name = "portfolio_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "belongs_to", nullable = false)
	private String belongs_to;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@OneToOne(mappedBy = "portfolio")
    private AboutMe aboutMe;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User myUser;

	@OneToMany(mappedBy = "portfolio")
	private Set<Project> projects;
	
	@OneToMany(mappedBy = "portfolio")
	private Set<Education> education;
	
	@OneToMany(mappedBy = "portfolio")
	private Set<SkillMatrix> skillMatrix;
	

}
