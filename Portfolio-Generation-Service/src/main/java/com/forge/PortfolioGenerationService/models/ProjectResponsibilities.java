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
@Table(name = "project_responsibilites")
public class ProjectResponsibilities {

	@Id
	@Column(name = "project_responsibilities_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "content", nullable = false)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="project_id", nullable=false)
	private Project project;
}
