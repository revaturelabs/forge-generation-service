package com.forge.PDFGenerationService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forge.PDFGenerationService.models.User;
import com.forge.PDFGenerationService.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userR;
	
	public UserService(UserRepo userR) {
		this.userR = userR;
	}
	
	public User update(User user) {
		return this.userR.save(user);

	}
	
	public List<User> getAllUsers() {
		return userR.findAll();
	}
	
	public User getUserById(int id) {
		return userR.findByUserId(id);
	}
}
