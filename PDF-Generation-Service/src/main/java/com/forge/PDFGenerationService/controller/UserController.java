package com.forge.PDFGenerationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.forge.PDFGenerationService.models.User;
import com.forge.PDFGenerationService.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userS;
	
	public UserController(UserService userS) {
		this.userS=userS;
	}
	
	@GetMapping("/getUser")
	public List<User> getUser() {
		
		return userS.getAllUsers();
	}
	
	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable("id") int id) {
		User u = userS.getUserById(id);
		if(u==null) {
			return new User();
		}
		return u;
	}
	
	@PostMapping(value="/createUser",consumes="application/json")
	public String createUser(@RequestBody User user) {
		userS.update(user);
		return "saved: " + user;
	}
	
	@PutMapping("/updateUser") 
	public User updateUser(@RequestBody User user) {
		return userS.update(user);
	}
}
