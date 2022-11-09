package com.wellsfargo.training.cfms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.training.cfms.exception.ResourceNotFoundException;
import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public Map<String, Object> loginDealer(@Validated @RequestBody User user) throws ResourceNotFoundException
	{
		String email=user.getEmail();
		String password=user.getPassword();
		user.setActivated(true);
		User user1 = userService.loginUser(email).orElseThrow(() ->
		new ResourceNotFoundException("User not found for this user id. "));


		if(email.equals(user1.getEmail()) && password.equals(user1.getPassword())) {
			return new HashMap<String, Object>() {{
				
					put("userId", user1.getId());
					put("firstName", user1.getFirstName());
					put("lastName", user1.getLastName());
					put("userName", user1.getUserName());
					put("status", "success");
					put("message", "user logged in successfully");
					
				}};
			}
		

		return new HashMap<String, Object>() {{
			put("status", "error");
			put("message", "Wrong Password or invalid user");
		}};
		
		
	}
}
