package com.wellsfargo.training.cfms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.training.cfms.exception.ResourceNotFoundException;
import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
@RequestMapping(value="/api")
public class LoginController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public User loginDealer(@Validated @RequestBody User user) throws ResourceNotFoundException
	{
		String email=user.getEmail();
		String password=user.getPassword();
		User user1 = userService.loginUser(email).orElseThrow(() ->
		new ResourceNotFoundException("User not found for this user id. "));


		if(email.equals(user1.getEmail()) && password.equals(user1.getPassword())) {
			return user1;
		}

		return null;
		
		
	}
}
