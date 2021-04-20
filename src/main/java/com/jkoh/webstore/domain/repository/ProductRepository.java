package com.jkoh.webstore.domain.repository;

import java.util.List;
import java.util.Map;

import com.jkoh.webstore.domain.Product;

public interface ProductRepository {
	List<Product> getAllProducts();
	void updateStock(String productId, long noOfUnits);
	List<Product> getProductsByCategory(String category);
	List<Product> getProductByFilter(Map<String, List<String>> filterParams);
	
}
