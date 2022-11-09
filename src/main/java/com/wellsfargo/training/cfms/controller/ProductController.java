package com.wellsfargo.training.cfms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.service.CardService;
import com.wellsfargo.training.cfms.service.ProductService;
import com.wellsfargo.training.cfms.service.TransactionInfoService;
import com.wellsfargo.training.cfms.service.UserCardService;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
@RequestMapping(value="/api")
public class ProductController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserCardService userCardService;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	TransactionInfoService transactionInfoService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/purchase")
	public void purchaseProduct(@RequestBody Long productId) {
		// user buying stuff
		
	}

}
