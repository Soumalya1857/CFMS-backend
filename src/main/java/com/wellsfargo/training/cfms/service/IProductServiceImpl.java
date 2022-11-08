package com.wellsfargo.training.cfms.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.training.cfms.model.Product;

public interface IProductServiceImpl {
	
	public Optional<Product> getProduct (Long productId);
	
}
