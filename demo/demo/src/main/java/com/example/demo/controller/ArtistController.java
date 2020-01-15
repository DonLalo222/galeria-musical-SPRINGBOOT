package com.example.demo.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Artist;
import com.example.demo.model.Category;
import com.example.demo.model.Image;
import com.example.demo.service.ArtistService;
import com.example.demo.service.CategoryService;

@Controller
public class ArtistController {

	@Autowired
	private ArtistService artistService;
	private CategoryService categoryService;
	private Image img;
	
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
	public String create(Model model) {
		try {
			Iterable<Category> categories = categoryService.findAll();
			model.addAttribute("categories", categories);
			//
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("title", "Artista - Crear");
		return "artist/create";
	}
	
	@PostMapping("/artista/guardar")
	public String save(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String description) {
		
		/*String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		String newName = file.getOriginalFilename().replace(file.getOriginalFilename(), 1 + "." + extension);*/
		Artist art = new Artist();
		try {
			art.setName(name);
			art.setDescription(description);
			art.setUrlPhoto(img.getRandomName(file.getOriginalFilename().replace(".", "-")));
			artistService.save(art);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/artista/crear";
	}
	
}
