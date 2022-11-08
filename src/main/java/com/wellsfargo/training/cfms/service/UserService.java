package com.wellsfargo.training.cfms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.cfms.model.User;
import com.wellsfargo.training.cfms.repository.UserRepository;



@Transactional
@Service
public class UserService implements IUserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	public User registerUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public Optional<User> loginUser(String email) {
		
		return userRepository.findByEmail(email); 
	}

}
