package com.forge.PortfolioGenerationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.SkillMatrix;

@Repository
public interface SkillMatrixRepository extends JpaRepository<SkillMatrix , Integer> {

}
