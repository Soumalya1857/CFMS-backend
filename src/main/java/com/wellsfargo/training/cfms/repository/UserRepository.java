package com.wellsfargo.training.cfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
