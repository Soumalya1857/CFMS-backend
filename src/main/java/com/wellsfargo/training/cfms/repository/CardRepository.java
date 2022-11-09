package com.wellsfargo.training.cfms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{
	
	public Optional<Card> findByCardType(String cardType);
}
