package com.wellsfargo.training.cfms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.cfms.model.TransactionInfo;
import com.wellsfargo.training.cfms.repository.TransactionInfoRepository;

@Service
public class TransactionInfoService implements ITransactionInfoServiceImpl {
	
	@Autowired
	private TransactionInfoRepository transactionInfoRepository;
	
	public TransactionInfo postTransact(TransactionInfo transactionInfo) {
		return transactionInfoRepository.save(transactionInfo);
	}
	
	public Optional<TransactionInfo> getTransaction ( Long transactionId) {
		return transactionInfoRepository.findById(transactionId);
		
	}
	
	public List<TransactionInfo> getAllTransaction(Long userId){
		return transactionInfoRepository.findByUserId(userId);
	}
}
