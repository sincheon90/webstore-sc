package com.jkoh.webstore.service;

import java.util.List;

import com.jkoh.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void updateAllStock();
	List<Product> getProductsByCategory(String category);
	
}
