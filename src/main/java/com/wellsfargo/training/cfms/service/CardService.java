package com.wellsfargo.training.cfms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.cfms.model.Card;
import com.wellsfargo.training.cfms.repository.CardRepository;

@Service
@Transactional

public class CardService implements ICardServiceImpl {
	
	@Autowired
	private CardRepository cardRepository;
	
	
	public Optional<Card> getCard(String cardType){
		return cardRepository.findByCardType(cardType);
	}
	
	
	
}
