package com.wellsfargo.training.cfms.service;

import java.util.Optional;

import com.wellsfargo.training.cfms.model.Card;

public interface ICardServiceImpl {
	
	public Optional<Card> getCard(String cardType);
}
