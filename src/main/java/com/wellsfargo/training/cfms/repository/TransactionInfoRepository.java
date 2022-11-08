package com.wellsfargo.training.cfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.TransactionInfo;

public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Long> {

}
