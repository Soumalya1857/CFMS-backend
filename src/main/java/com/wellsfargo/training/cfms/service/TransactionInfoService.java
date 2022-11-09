package com.wellsfargo.training.cfms.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.cfms.model.Card;
import com.wellsfargo.training.cfms.model.TransactionInfo;
import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.model.UserCard;
import com.wellsfargo.training.cfms.repository.TransactionInfoRepository;

@Service
@Transactional

public class TransactionInfoService implements ITransactionInfoServiceImpl {
	
	@Autowired
	private TransactionInfoRepository transactionInfoRepository;
	
	public TransactionInfo saveTransactionInfo(TransactionInfo transactionInfo) {
		return transactionInfoRepository.save(transactionInfo);
	}
	
	public Optional<TransactionInfo> getTransaction ( Long transactionId) {
		return transactionInfoRepository.findById(transactionId);
		
	}
	
	public List<TransactionInfo> getAllTransaction(Long userId){
		return transactionInfoRepository.findByUserId(userId);
	}
	
	public TransactionInfo transactionBuilder(Card genericCard, UserCard userCard, User user ) {
		TransactionInfo newTransaction = new TransactionInfo();
		newTransaction.setAmountPaid(genericCard.getJoiningFee());
		newTransaction.setProductId(Long.valueOf(0));
		newTransaction.setUserCardId(userCard.getId());
		newTransaction.setOutstanding(false);
		newTransaction.setCompleted(true);
		newTransaction.setUserId(user.getId());
		newTransaction.setDate(Calendar.getInstance().getTime());
		
		//transactionInfoRepository.save(newTransaction);
		return newTransaction;
		
	}
}
