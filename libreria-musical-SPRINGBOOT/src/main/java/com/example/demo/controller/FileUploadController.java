package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@PostMapping("/uploadfile")
	public void uploadFile(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		System.out.println(extension);
		file.transferTo(new File("C:\\Users\\gvasq\\Documents\\workspace-spring-tool-suite-4-4.5.0.RELEASE\\demo\\src\\main\\resources\\images\\" + file.getOriginalFilename()));
	}
	
	@GetMapping("/uploadfile/form")
	public String form() {
		
		return "uploadfile";
	}
}
