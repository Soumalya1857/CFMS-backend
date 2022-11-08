package com.wellsfargo.training.cfms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.cfms.model.Product;
import com.wellsfargo.training.cfms.repository.ProductRepository;

@Service
@Transactional
public class ProductService implements IProductServiceImpl {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product postProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> getProduct (Long productId) {
		System.out.print(productId);
		return productRepository.findByProductId(productId);
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
}
