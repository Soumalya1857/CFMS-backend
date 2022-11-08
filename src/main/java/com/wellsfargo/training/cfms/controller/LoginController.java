package com.wellsfargo.training.cfms.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
public class LoginController {
	@Autowired
	UserService userService;
	@GetMapping("/loginUser")
	public Optional<User> loginUser(@RequestBody Map<String,String> email) {
		
			System.out.print(email);
			return userService.loginUser(email.get("email"));
		}
}
