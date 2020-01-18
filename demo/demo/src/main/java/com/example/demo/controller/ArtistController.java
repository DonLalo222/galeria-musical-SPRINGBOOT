package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.IFileDao;
import com.example.demo.model.Artist;
import com.example.demo.model.Category;
import com.example.demo.service.ArtistService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.FileService;

@Controller
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FileService fileService;
	
	@GetMapping("/artista/index")
	public String index(Model model) {
		try {
			Iterable<Artist> items = artistService.findAll();
			model.addAttribute("items", items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("title", "Artista - Index");
		return "artist/index";
	}
	
	@GetMapping("/artista/crear")
	public String create(Model model, @ModelAttribute Artist artist) {
		try {
			Iterable<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("artist", artist);
		model.addAttribute("title", "Artista - Crear");
		return "artist/create";
	}
	
	@PostMapping("/artista/guardar")
	public String save(@RequestParam("file") MultipartFile file,
			@ModelAttribute Artist artist,
			RedirectAttributes ra) {
		Artist art = new Artist();
		try {
			art.setName(artist.getName());
			art.setDescription(artist.getDescription());
			art.setUrlPhoto(fileService.upload(file));
			art.setCategory(artist.getCategory());
			//
			artistService.save(art);
			ra.addFlashAttribute("success", "datos guardados!");
			ra.addFlashAttribute("class", "alert alert-success");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/artista/crear";
	}
	
	@GetMapping("/artista/detalles/{id}")
	public String detalles(@ModelAttribute Artist artist,
			Model model,
			@PathVariable Long id) {
		try {
			Optional<Artist> art = artistService.findById(id);
			model.addAttribute("item", art.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("title", "Artista - Detalles");
		return "/artist/details";
	}
	
	
	
}
