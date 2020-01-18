package com.example.demo.dao;

import org.springframework.web.multipart.MultipartFile;

public interface IFileDao {

	
	String upload(MultipartFile file) throws Exception;
	
}
