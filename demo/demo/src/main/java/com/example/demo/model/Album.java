package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int year;
	@ManyToMany
	private Set<Artist> artist;
	@ManyToOne
	private Category category;
	private String urlCover;
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public Set<Artist> getArtist() {
		return artist;
	}
	public void setArtist(Set<Artist> artist) {
		this.artist = artist;
	}
	public String getUrlCover() {
		return urlCover;
	}
	public void setUrlCover(String urlCover) {
		this.urlCover = urlCover;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
