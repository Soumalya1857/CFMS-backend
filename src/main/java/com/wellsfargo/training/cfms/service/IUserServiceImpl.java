package com.wellsfargo.training.cfms.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.training.cfms.model.User;

public interface IUserServiceImpl {
	
	public User registerUser(User user);
	public List<User> getAllUser();
	public Optional<User> loginUser(String email);
	
}
