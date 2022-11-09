package com.wellsfargo.training.cfms.service;

import java.util.Calendar;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.cfms.model.Card;
import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.model.UserCard;
import com.wellsfargo.training.cfms.repository.UserCardRepository;

@Service
@Transactional
public class UserCardService implements IUserCardServiceImpl {
	
	@Autowired
	private UserCardRepository userCardRepository;

	public UserCard createNewUserCard(UserCard userCard) {
		return userCardRepository.save(userCard);
	}
	
	public UserCard cardBuilder(User user, Card genericCard) {
		
		Calendar cal = Calendar.getInstance();
		
		UserCard userCard = new UserCard();
		userCard.setUserId(user.getId());
		userCard.setCardType(user.getCardType().toLowerCase());
		userCard.setUseableCreditLimit( genericCard.getCreditLimit() - genericCard.getJoiningFee());
		userCard.setActivated( user.isActivated() );
		userCard.setIssueDate(cal.getTime());
		cal.add(Calendar.YEAR, 5);
		userCard.setValidity(cal.getTime());
		
		// userCardRepository.save(userCard);
		return userCard;
	}
	
	public Optional<UserCard> getUserCard (Long userId) {
		return userCardRepository.findByUserId(userId);
	}
	
	
	
}
