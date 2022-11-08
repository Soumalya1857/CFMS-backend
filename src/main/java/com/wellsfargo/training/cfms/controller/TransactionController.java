package com.wellsfargo.training.cfms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.TransactionInfo;

import com.wellsfargo.training.cfms.service.TransactionInfoService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class TransactionController {
	@Autowired(required = true)
	TransactionInfoService transactionInfoService;
	
	@PostMapping("/postTransactions")
	public void postTransact(@RequestBody TransactionInfo transactionInfo) {
		transactionInfoService.postTransact(transactionInfo);
	}
	
	@GetMapping("/getTransactions")
	public List<TransactionInfo> getAllTransaction(@RequestBody Map<String,Long> userId){
		System.out.print(userId);
		return transactionInfoService.getAllTransaction(userId.get("userId"));
	}
	
	@GetMapping("/getTransactionById")
	public Optional<TransactionInfo> getTransaction (@RequestBody Map<String,Long> transactionId) {
		System.out.print(transactionId);
		return transactionInfoService.getTransaction(transactionId.get("transactionId"));
		
	}
}
