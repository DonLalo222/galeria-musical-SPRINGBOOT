package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.IFileDao;

@Service
public class FileService {
	@Autowired
	private IFileDao img;
	
	public String upload(MultipartFile file) throws Exception{
		return img.upload(file);
	}

}
