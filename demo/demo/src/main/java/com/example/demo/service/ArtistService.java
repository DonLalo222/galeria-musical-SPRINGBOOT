package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Artist;
import com.example.demo.repository.IArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private IArtistRepository repo;
	
	public void save(Artist artist) throws Exception{
		repo.save(artist);
	}
	
	public Iterable<Artist> findAll() throws Exception{
		return repo.findAll();
	}
	
	public Optional<Artist> findById(Long id) throws Exception{
		return repo.findById(id);
	}
	
	public void deleteById(Long id) throws Exception{
		repo.deleteById(id);
	}
}
