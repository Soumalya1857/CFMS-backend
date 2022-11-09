package com.wellsfargo.training.cfms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.TransactionInfo;

import com.wellsfargo.training.cfms.service.TransactionInfoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class TransactionController {
	@Autowired(required = true)
	TransactionInfoService transactionInfoService;
	
	@GetMapping("/getTransactions")
	public List<TransactionInfo> getAllTransaction(@RequestBody Map<String,Long> userBody){
		System.out.print(userBody);
		return transactionInfoService.getAllTransaction(userBody.get("userId"));
	}
	
	@GetMapping("/getTransactionById")
	public Optional<TransactionInfo> getTransaction (@RequestBody Map<String,Long> transactionBody) {
		System.out.print(transactionBody);
		return transactionInfoService.getTransaction(transactionBody.get("transactionId"));
		
	}
}
