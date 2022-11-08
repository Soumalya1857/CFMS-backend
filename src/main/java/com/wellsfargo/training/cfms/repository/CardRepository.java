package com.wellsfargo.training.cfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.Card;

public interface CardRepository extends JpaRepository<Card, Long>{

}
