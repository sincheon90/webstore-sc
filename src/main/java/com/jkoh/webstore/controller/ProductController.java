package com.jkoh.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jkoh.webstore.domain.repository.ProductRepository;
import com.jkoh.webstore.service.ProductService;

@RequestMapping("market")
@Controller
public class ProductController {
//	@Autowired
//	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public String list(Model model) {
		//model.addAttribute("products", productRepository.getAllProducts()); // 모델에 추가
		model.addAttribute("products", productService.getAllProducts());
		return "products"; // 뷰 이름 반환
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products"; // forward vs redirect vs 둘다 없이
	}
	
	@RequestMapping("products/{category}")
	public String getProductByCategory(Model model,
			@PathVariable("category") String productCategory) { 
		// @PathVariable String category) {
		model.addAttribute("products", 
				productService.getProductsByCategory(productCategory));
				// productService.getProductsByCategory(category));
		return "products";
	}
	
	@RequestMapping("products/filter/{params}/{specification}")
	public String getProductByFilter(Model model,
			@MatrixVariable(pathVar="params") Map<String, List<String>> filterSpec,
			@MatrixVariable(pathVar="specification") Map<String, List<String>> filterParams) {
		model.addAttribute("products", productService.getProductByFilter(filterParams));
		return "products";
	}
	
	
}
