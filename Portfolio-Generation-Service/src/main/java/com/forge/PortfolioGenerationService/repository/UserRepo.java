package com.forge.PortfolioGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PortfolioGenerationService.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	
	public User createUser(User user);
	
	public List<User> findAllUsers();
	
	public User findByUserId(int id);
	
	public User findByUserFirstName(String firstName);
	
	public User findByUsername(String username);
	
	public void updateUser(User user);
	
	public void deleteUser(User user);
}
