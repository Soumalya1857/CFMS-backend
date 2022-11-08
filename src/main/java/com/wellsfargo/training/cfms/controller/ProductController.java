package com.wellsfargo.training.cfms.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.cfms.model.Product;
import com.wellsfargo.training.cfms.service.ProductService;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
@Autowired
ProductService productService;

@PostMapping("/postProduct")
public String postProduct(@RequestBody Product product) {
	productService.postProduct(product);
	return "Success";
}

@GetMapping("/getProduct")
public Optional<Product> getProduct (@RequestBody Map<String,Long> productId) {
	System.out.print(productId);
	return productService.getProduct(productId.get("productId"));
}

@GetMapping("/getAllProducts")
public List<Product> getAllProduct(){
	return productService.getAllProduct();
}
}
