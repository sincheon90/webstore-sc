package com.jkoh.webstore.controller;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jkoh.webstore.domain.Product;

@Controller
public class ProductController2 {
	@RequestMapping("/products2")
	public String list(Model model) {
		Product galaxy = new Product("sm1679", "Galaxy Note7", new BigDecimal(1500));
		galaxy.setDescription(
				"169g, 7.9mm thickness\r\n"
				+ "Android 6.0.1, TouchWiz UI\r\n"
				+ "64GB storage, microSDXC");
		galaxy.setCategory("smartphone");
		galaxy.setManufacturer("SAMSUNG");
		galaxy.setUnitsInStock(5000);
		model.addAttribute("product", galaxy);
		return "products";
	}
}
