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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "portfolio")
@EqualsAndHashCode(exclude = {"projects", "education", "skillMatrix"})
public class Portfolio {
 
	@Id
	@Column(name = "portfolio_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "belongs_to", nullable = false)
	private String belongsTo;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@OneToOne(mappedBy = "portfolio")
	@JsonManagedReference
    private AboutMe aboutMe;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	@JsonBackReference
	private User myUser;

	@OneToMany(mappedBy = "portfolio")
	@JsonManagedReference
	private Set<Project> projects;
	
	@OneToMany(mappedBy = "portfolio")
	@JsonManagedReference
	private Set<Education> education;
	
	@OneToMany(mappedBy = "portfolio")
	@JsonManagedReference
	private Set<SkillMatrix> skillMatrix;
	

}
