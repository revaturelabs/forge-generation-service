package com.forge.PortfolioGenerationService.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skill_matrix_item")
public class SkillMatrixItem {

	@Id
	@Column(name = "skill_matrix_item_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "experience")
	private String experience;
	
	@ManyToOne
	@JoinColumn(name="skill_matrix_id", nullable=false)
	private SkillMatrix skillMatrix;
}
