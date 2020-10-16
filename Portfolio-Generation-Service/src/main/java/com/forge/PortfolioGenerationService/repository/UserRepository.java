package com.forge.PortfolioGenerationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	

}
