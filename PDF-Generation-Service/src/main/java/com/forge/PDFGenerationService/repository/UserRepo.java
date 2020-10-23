package com.forge.PDFGenerationService.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.forge.PDFGenerationService.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer>{
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	
	public List<User> findAll();
	
	public User findByUserId(int id);
	
	public User findByFirstName(String firstName);
	
	public User findByEmail(String username);
	
	public void delete(User user);
	
}
