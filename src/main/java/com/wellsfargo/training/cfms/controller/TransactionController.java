package com.wellsfargo.training.cfms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.Product;
import com.wellsfargo.training.cfms.model.TransactionInfo;
import com.wellsfargo.training.cfms.service.ProductService;
import com.wellsfargo.training.cfms.service.TransactionInfoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TransactionController {
	@Autowired(required = true)
	TransactionInfoService transactionInfoService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/getAllTransactions")
	public List<HashMap<String, Object>> getAllTransaction(@RequestBody Map<String,Long> userBody){
		List<TransactionInfo> transactionList = transactionInfoService.getAllTransaction(userBody.get("userId"));
		
		List<HashMap<String, Object>> returnObj = new ArrayList< HashMap<String, Object>>();
		
		for(int i=0 ; i<transactionList.size(); i++) {
			boolean check = false;
			
			if(productService.getProduct(transactionList.get(i).getProductId()).isPresent()) {
				check = true;
			}
			
			HashMap<String, Object> currHashmap = new HashMap<String, Object>(); 

			
				currHashmap.put("transactionId", transactionList.get(i).getTransactionId());
				currHashmap.put("amountPaid", transactionList.get(i).getAmountPaid());
				currHashmap.put("productId", transactionList.get(i).getProductId());
				currHashmap.put("userCardId", transactionList.get(i).getUserCardId());
				currHashmap.put("outStanding", transactionList.get(i).isOutstanding());
				currHashmap.put("completed", transactionList.get(i).isCompleted());
				currHashmap.put("userId", transactionList.get(i).getUserId());
				currHashmap.put("date", transactionList.get(i).getDate());
				currHashmap.put("productName", check ? productService.getProduct(transactionList.get(i).getProductId()).get().getProductName(): "Joining Fee");
			
			
			returnObj.add(currHashmap);
		}
		
		return returnObj;
		
	}
	
	@PostMapping("/getTransactionById")
	public Optional<TransactionInfo> getTransaction (@RequestBody Map<String,Long> transactionBody) {
		System.out.print(transactionBody);
		return transactionInfoService.getTransaction(transactionBody.get("transactionId"));
		
	}
}
