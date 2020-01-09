package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistController {
	@GetMapping("/artista/index")
	public String index(Model model) {
		model.addAttribute("title", "artista - index");
		return "artist/index";
	}
	
	@GetMapping("/artista/form")
	public String form(Model model) {
		model.addAttribute("title", "artista - form");
		return "artist/form";
	}
	
}
