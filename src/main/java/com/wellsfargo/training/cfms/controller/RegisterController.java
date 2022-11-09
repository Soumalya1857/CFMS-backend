package com.wellsfargo.training.cfms.controller;

import java.util.List;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.Card;
import com.wellsfargo.training.cfms.model.TransactionInfo;
import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.model.UserCard;
import com.wellsfargo.training.cfms.service.CardService;
import com.wellsfargo.training.cfms.service.TransactionInfoService;
import com.wellsfargo.training.cfms.service.UserCardService;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
@RequestMapping(value="/api")
public class RegisterController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserCardService userCardService;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	TransactionInfoService transactionInfoService;
	
	@PostMapping("/register")
	public void registerUser(@RequestBody User user) {
		userService.registerUser(user);
		// restrict user from register multiple times again
		
		// create a user card based on the user card type
		Card genericCard = cardService.getCard( user.getCardType()).get();
		// create the userCard
		UserCard userCard = userCardService.cardBuilder(user, genericCard);
		userCardService.createNewUserCard(userCard);
		
		// create a transaction object details too and save them
		TransactionInfo newTransaction = transactionInfoService.transactionBuilder(genericCard, userCard, user);
		transactionInfoService.saveTransactionInfo(newTransaction);
		
		// product purchase logic => done
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
}
