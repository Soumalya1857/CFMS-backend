package com.wellsfargo.training.cfms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.Card;
import com.wellsfargo.training.cfms.model.UserCard;
import com.wellsfargo.training.cfms.service.CardService;
import com.wellsfargo.training.cfms.service.UserCardService;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserCardController {
	
	@Autowired
	UserCardService userCardService;
	
	@Autowired
	CardService cardService;
	
	@PostMapping("/getCardDetails")
	public Map<String, Object> getCardDetails(@RequestBody Map<String, Long> body) {
		UserCard userCard = userCardService.getUserCard(body.get("userId")).get();
		
		Card card = cardService.getCard(userCard.getCardType()).get();
		
		return new HashMap <String,Object>() {{
			put("validity", userCard.getValidity());
			put("cardType", userCard.getCardType());
			put("validity", userCard.getValidity());
			put("status", "Activated");
			put("issueDate", userCard.getIssueDate());
			put("remainingCredit", userCard.getUseableCreditLimit());
			put("totalCredit", card.getCreditLimit());
			put("creditUsed", card.getCreditLimit() - userCard.getUseableCreditLimit());
		}};
		
	}

}
