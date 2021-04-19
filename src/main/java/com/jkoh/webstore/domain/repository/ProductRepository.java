package com.jkoh.webstore.domain.repository;

import java.util.List;

import com.jkoh.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId, long noOfUnits);
	List<Product> getAllProductsByCategory(String category);
	
}
