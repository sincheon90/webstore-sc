package com.jkoh.webstore.service;

import java.util.List;
import java.util.Map;

import com.jkoh.webstore.domain.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void updateAllStock();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductByFilter(Map<String, List<String>> filterParams);
	Product getProductById(String productID);
	
}
