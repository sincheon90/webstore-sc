package com.jkoh.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
//	@RequestMapping("/")
//	public String welcome(Model model, RedirectAttributes redAttrs) {
//		String greeting = "환영합니다!";
//		String tagline = "세상에서 하나 뿐인 웹 가게";
//
//		model.addAttribute("greeting", greeting);
//		model.addAttribute("tagline", tagline);
//		redAttrs.addFlashAttribute("greeting", greeting);
//		redAttrs.addFlashAttribute("tagline", tagline);
//		return "redirect:/welcome/greeting";
//	}
//	
//	@RequestMapping("/welcome/greeting")
//	public String greeting(Model model) {
//		//model.addAttribute("tagline", "더조은학원");
//		return "welcome";
//	}
	
	@RequestMapping
	public String welcome(Model model) {
		model.addAttribute("greeting", "안녕!");
		model.addAttribute("tagline", "웹스토어");
		return "forward:/welcome/greeting";
	}

	@RequestMapping("/welcome/greeting")
	public String greeting(Model model) {
		model.addAttribute("tagline", "더조은학원");
		return "welcome";
	}
}
