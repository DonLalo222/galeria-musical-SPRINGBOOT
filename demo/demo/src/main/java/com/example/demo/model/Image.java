package com.example.demo.model;

import java.io.File;
import java.util.UUID;

public class Image {

	private String serverpath = "C:\\Users\\gvasq\\Desktop\\GIT\\demo\\demo\\src\\main\\resources\\static\\img\\";
	
	public Image() {
	
	}
	
	public String getRandomName(String name) {
		String salida = name.replace(" ", "-");
		String aleatorio = UUID.randomUUID().toString();
		
		return salida + "-" + aleatorio;
	}
	
	
}
