package com.wellsfargo.training.cfms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellsfargo.training.cfms.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
