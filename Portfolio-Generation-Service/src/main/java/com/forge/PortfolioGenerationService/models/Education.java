package com.forge.PortfolioGenerationService.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education")
@EqualsAndHashCode(exclude = {"portfolio"})
public class Education {

	@Id
	@Column(name = "education_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "university")
	private String university;
	
	@Column(name = "graduation")
	private Date graduation;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "minor")
	private String minor; 
	
	@ManyToOne
	@JoinColumn(name="portfolio_id", nullable=false)
	@JsonBackReference
	private Portfolio portfolio;
	
}
