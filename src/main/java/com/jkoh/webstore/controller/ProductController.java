package com.jkoh.webstore.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	
	@RequestMapping("/product") // 7절 실습
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		System.out.println("RequestMethod.GET");
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}

	@RequestMapping(value = "/products/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8")
	public String processAddNewProductForm(@ModelAttribute("newProduct")Product newProduct, 
			BindingResult result, Model model, HttpServletRequest request) {
		try {
			String[] suppressedFields = result.getSuppressedFields();
			if (suppressedFields.length > 0) {
				throw new RuntimeException(
						"허용되지 않은 항목을 엮어오려고함: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
			} else {
				/**
				 * 상품 영상 메모리 내용 정한 폴더에 파일로 보관
				 */
				MultipartFile productImage = newProduct.getProductImage();
				String rootDirectory = request.getSession().getServletContext().getRealPath("/");
				if (productImage != null && !productImage.isEmpty()) {
					try {
						productImage.transferTo(
								new File(rootDirectory + "resources\\images\\" + newProduct.getProductId() + ".png"));
					} catch (Exception e) {
						throw new RuntimeException("Product Image saving failed", e);
					}
				}
				productService.addProduct(newProduct);
			}
			return "redirect:/market/products";
		} catch (DataAccessException e) {
			String msg = e.getMessage();
			int idx = msg.lastIndexOf("Duplicate");
			model.addAttribute("errorMsg", msg.substring(idx));
			return "addProduct";
		}
	}
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unit*", "description", "manufacturer", "category",
				"condition", "productImage");
	}

}
