package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Category;

@Controller
public class CategoryController {
	@GetMapping("/categoria/index")
	public String index(Model model) {
		model.addAttribute("title", "Categoria - Index");
		return "category/index";
	}
	
	@GetMapping("/categoria/crear")
	public String index(Model model, @ModelAttribute Category category) {
		model.addAttribute("title", "Categoria - Crear");
		model.addAttribute("category", category);
		return "category/create";
	}

}
