package com.wellsfargo.training.cfms.service;

import java.util.Optional;

import com.wellsfargo.training.cfms.model.Card;

public interface IUserCardServiceImpl {
	public Optional<Card> getTransaction ( );
}
