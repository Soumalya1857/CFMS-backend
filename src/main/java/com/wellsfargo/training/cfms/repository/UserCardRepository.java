package com.wellsfargo.training.cfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.UserCard;

public interface UserCardRepository extends JpaRepository<UserCard, Long> {

}
