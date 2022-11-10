package com.wellsfargo.training.cfms.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.model.Card;
import com.wellsfargo.training.cfms.model.Product;
import com.wellsfargo.training.cfms.model.TransactionInfo;
import com.wellsfargo.training.cfms.model.UserCard;
import com.wellsfargo.training.cfms.service.CardService;
import com.wellsfargo.training.cfms.service.ProductService;
import com.wellsfargo.training.cfms.service.TransactionInfoService;
import com.wellsfargo.training.cfms.service.UserCardService;
import com.wellsfargo.training.cfms.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	public Map<String,Object> purchaseProduct(@RequestBody Map<String,Long> details) {
		// user buying stuff
		Long productId = details.get("productId");
		Long userId = details.get("userId");
		Long numberOfEmis = details.get("numberOfEmis");
		
		

		
		Product purchasableProduct = productService.getProduct(productId).get();
		UserCard currUserCard = userCardService.getUserCard(userId).get();
		User currUser = userService.findById(userId).get();
		Card genericCard = cardService.getCard( currUser.getCardType()).get();
		
		Long limit = currUserCard.getUseableCreditLimit() - (purchasableProduct.getCost() / numberOfEmis);
		if (limit < 0) {
			// purchase fail
			return new HashMap<String, Object>() {{		    
				put("status", "error");
			    put("message", "Cannot initiate purchase due to low amount");
			}};
		}
	
		// go on purchasing and add transactions
		// create the outStanding transactions with 1 completed transaction
		TransactionInfo newTransaction = new TransactionInfo();
		newTransaction.setAmountPaid(purchasableProduct.getCost() / numberOfEmis);
		newTransaction.setProductId(Long.valueOf(productId));
		newTransaction.setUserCardId(currUserCard.getId());
		newTransaction.setOutstanding(false);
		newTransaction.setCompleted(true);
		newTransaction.setUserId(currUser.getId());
		newTransaction.setDate(Calendar.getInstance().getTime());
		
		transactionInfoService.saveTransactionInfo(newTransaction);
		currUserCard.setUseableCreditLimit(limit);
		
		
		TransactionInfo newTransaction1 = new TransactionInfo();
		Calendar cal = Calendar.getInstance(); 
		
//		for(int i = 1; i<numberOfEmis; i++) {
//			cal.add(Calendar.MONTH, 1);
//			newTransaction1.setAmountPaid( purchasableProduct.getCost() / numberOfEmis );
//			newTransaction1.setProductId(Long.valueOf(productId));
//			newTransaction1.setUserCardId(currUserCard.getId());
//			newTransaction1.setOutstanding(true);
//			newTransaction1.setCompleted(false);
//			newTransaction1.setUserId(currUser.getId());
//			newTransaction1.setDate(cal.getTime());
//			
//			transactionInfoService.saveTransactionInfo(newTransaction1);
//			
//		}
		
		
		return new HashMap<String, Object>() {{
			put("status", "success");
		    put("message", "Purchase done successfully!");
		}};
	 }
	
	@PostMapping("/getProduct") 
	public Optional<Product> getProductDetails(@RequestBody Map<String,Long> productDetails) {
		return productService.getProduct(productDetails.get("productId"));
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}

}
