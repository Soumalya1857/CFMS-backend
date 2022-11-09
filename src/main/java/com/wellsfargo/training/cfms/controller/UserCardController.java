package com.wellsfargo.training.cfms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.UserCard;
import com.wellsfargo.training.cfms.service.UserCardService;

@RestController
@RequestMapping(value="/api")
public class UserCardController {
	
	@Autowired
	UserCardService userCardService;
	
	@GetMapping("/getCardDetails")
	public UserCard getCardDetails(@RequestBody Map<String, Long> body) {
		return userCardService.getUserCard(body.get("userId")).get();
	}

}
