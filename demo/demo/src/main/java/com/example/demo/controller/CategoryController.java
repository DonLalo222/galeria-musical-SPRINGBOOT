package com.example.demo.controller;

import java.util.Optional;

import javax.validation.constraints.AssertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping("/categoria/index")
	public String index(Model model) {
		try {
			Iterable<Category> items = service.findAll();
			model.addAttribute("items", items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("title", "Categoria - Index");
		return "category/index";
	}
	
	@GetMapping("/categoria/crear")
	public String create(Model model, @ModelAttribute Category category) {
		model.addAttribute("title", "Categoria - Crear");
		model.addAttribute("category", category);
		return "/category/create";
	}
	
	@PostMapping("/categoria/guardar")
	public String save(Model model, @ModelAttribute Category category, RedirectAttributes ra) {
		Category cat = new Category();
		cat.setName(category.getName().trim());
		cat.setDescription(category.getDescription().trim());
		try {
			service.save(cat);
			ra.addFlashAttribute("success", "datos guardados!");
			ra.addFlashAttribute("class", "alert alert-success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/categoria/crear";
	}
	
	@GetMapping("/categoria/editar/{id}")
	public String edit(@ModelAttribute Category category, @PathVariable Long id, Model model) {
		try {
			Optional<Category> cat = service.findById(id);
			model.addAttribute("category", cat);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("title", "Categoria - Editar");
		return "/category/edit";
	}
	
	@PostMapping("/categoria/actualizar")
	public String update(@ModelAttribute Category category, RedirectAttributes ra) {
		Category c = null;
		try {
			Optional<Category> cat = service.findById(category.getId());
			if(cat.isPresent()) {
				c = cat.get();
				c.setName(category.getName());
				c.setDescription(category.getDescription());
				service.save(c);
				ra.addFlashAttribute("success", "datos guardados!");
				ra.addFlashAttribute("class", "alert alert-success");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/categoria/editar/" + c.getId();
	}
	
	@PostMapping("categoria/eliminar")
	public String delete(@RequestParam Long id, RedirectAttributes ra) {
		Category c = null;
		try {
			Optional<Category> cat = service.findById(id);
			if(cat.isPresent()) {
				c = cat.get();
				service.deleteById(c.getId());
				ra.addFlashAttribute("success", "Categoria Eliminada!");
				ra.addFlashAttribute("class", "alert alert-success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/categoria/index";
	}

	

}
