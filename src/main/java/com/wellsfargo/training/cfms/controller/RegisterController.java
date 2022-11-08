package com.wellsfargo.training.cfms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
public class RegisterController {
	@Autowired
	UserService userService;
	@PostMapping("/register")
	public void uploadDetails(@RequestBody User user) {
		userService.registerUser(user);
	}
	
	@GetMapping("/samp")
	public String uploadDetails() {
		return "hello";
	}
	
	@GetMapping("/findUsers")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/findUser/{mail}")
public Optional<User> loginUser(@PathVariable("mail") String email) {
		
		return userService.loginUser(email);
	}
}
