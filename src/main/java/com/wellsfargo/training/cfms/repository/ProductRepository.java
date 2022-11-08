package com.wellsfargo.training.cfms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.Product;
import com.wellsfargo.training.cfms.model.TransactionInfo;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<Product> findByProductId(Long productId);
}
