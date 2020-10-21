package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	
	public User save(User user);
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public User findByFirstName(String firstName);
	
	public User findByEmail(String username);
	
	public void delete(User user);
	
}
