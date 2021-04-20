package com.jkoh.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jkoh.webstore.domain.Product;
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
		// model.addAttribute("products", productRepository.getAllProducts()); // 모델에 추가
		model.addAttribute("products", productService.getAllProducts());
		return "products"; // 뷰 이름 반환
	}

	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStock();
		return "redirect:/market/products"; // forward vs redirect vs 둘다 없이
	}

	@RequestMapping("products/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String productCategory) {
		// @PathVariable String category) {
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		// productService.getProductsByCategory(category));
		return "products";
	}

	/*
	 * @RequestMapping("products/filter/{params}/{specification}") public String
	 * getProductByFilter(Model model,
	 * 
	 * @MatrixVariable(pathVar="params") Map<String, List<String>> filterSpec,
	 * 
	 * @MatrixVariable(pathVar="specification") Map<String, List<String>>
	 * filterParams) { model.addAttribute("products",
	 * productService.getProductByFilter(filterParams)); return "products"; }
	 */
	
	@RequestMapping("/product") // 7절 실습
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") 
			Product newProduct, BindingResult result) {
		String[] suppressedFields = result.getSuppressedFields();
		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		productService.addProduct(newProduct);
		return "redirect:/market/products";
	}

}
