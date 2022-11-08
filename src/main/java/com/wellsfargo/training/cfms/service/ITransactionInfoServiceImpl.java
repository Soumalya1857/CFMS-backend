package com.wellsfargo.training.cfms.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.training.cfms.model.TransactionInfo;

public interface ITransactionInfoServiceImpl {

	public Optional<TransactionInfo> getTransaction ( Long transactionId);
	public List<TransactionInfo> getAllTransaction (Long userId);
}
