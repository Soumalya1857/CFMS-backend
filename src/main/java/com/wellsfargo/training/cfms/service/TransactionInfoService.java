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
	
	public TransactionInfo transactionBuilderFromCard(Card genericCard, UserCard userCard, User user ) {
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
	
//	public void transactionBuilder(Card genericCard, Long cost, UserCard currUserCard, Long productId, User currUser, Long numberOfEmis) {
//		
//		TransactionInfo newTransaction = new TransactionInfo();
//		newTransaction.setAmountPaid();
//		newTransaction.setProductId(Long.valueOf(productId));
//		newTransaction.setUserCardId(currUserCard.getId());
//		newTransaction.setOutstanding(false);
//		newTransaction.setCompleted(true);
//		newTransaction.setUserId(currUser.getId());
//		newTransaction.setDate(Calendar.getInstance().getTime());
//		
//		transactionInfoRepository.save(newTransaction);
//		
//		for(int i = 1; i<numberOfEmis; i++) {
//			
//			Calendar cal = Calendar.getInstance(); 
//			cal.add(Calendar.MONTH, 1);
//			TransactionInfo newTransaction1 = new TransactionInfo();
//			newTransaction.setAmountPaid(genericCard.getJoiningFee());
//			newTransaction.setProductId(Long.valueOf(productId));
//			newTransaction.setUserCardId(currUserCard.getId());
//			newTransaction.setOutstanding(true);
//			newTransaction.setCompleted(false);
//			newTransaction.setUserId(currUser.getId());
//			newTransaction.setDate(cal.getTime());
//			
//			transactionInfoRepository.save(newTransaction1);
//			
//		}
//	}
}
