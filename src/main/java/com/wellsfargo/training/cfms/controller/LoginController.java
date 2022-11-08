package com.wellsfargo.training.cfms.controller;

<<<<<<< HEAD
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 2e71c33 (working commit on main)
import org.springframework.web.bind.annotation.RestController;
import com.wellsfargo.training.cfms.exception.ResourceNotFoundException;
import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
@RequestMapping(value="/api")
public class LoginController {
	@Autowired
	UserService userService;
<<<<<<< HEAD
	@GetMapping("/loginUser")
	public Optional<User> loginUser(@RequestBody Map<String,String> email) {
		
			System.out.print(email);
			return userService.loginUser(email.get("email"));
=======

	@PostMapping("/login")
	public User loginDealer(@Validated @RequestBody User user) throws ResourceNotFoundException
	{
		String email=user.getEmail();
		String password=user.getPassword();
		User user1 = userService.loginUser(email).orElseThrow(() ->
		new ResourceNotFoundException("User not found for this id :: "));;


		if(email.equals(user1.getEmail()) && password.equals(user1.getPassword()))
		{
			return user1;

>>>>>>> 2e71c33 (working commit on main)
		}

		return null;
	}
}
