package com.example.demo.dao;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileDaoImpl implements IFileDao {

	private String serverpath = "C:\\Users\\gvasq\\Desktop\\GIT\\demo\\demo\\src\\main\\resources\\static\\images\\";
	
	@Override
	public String upload(MultipartFile file) throws Exception {
		String ext = FilenameUtils.getExtension(file.getOriginalFilename());
		String fileFormatted = file.getOriginalFilename().replace(" ", "-").replace("." + ext, "-");
		String strRandom = UUID.randomUUID().toString();
		String newName = fileFormatted + strRandom + "." + ext;
		file.getOriginalFilename().replace(file.getOriginalFilename(), newName);
		String urlPhoto = "/images/" + newName;
		file.transferTo(new File(serverpath + newName));
		//
		return urlPhoto;
	}

}
