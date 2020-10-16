package com.forge.PortfolioGenerationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.Portfolio;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio , Integer> {

}
