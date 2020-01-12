package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private ICategoryRepository repo;
	
	public void save(Category category) throws Exception{
		repo.save(category);
	}
	
	public Iterable<Category> findAll() throws Exception{
		return repo.findAll();
	}
	
	public Optional<Category> findById(Long id) throws Exception{
		return repo.findById(id);
	}
	
	public void deleteById(Long id) throws Exception{
		repo.deleteById(id);
	}

}
