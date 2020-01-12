package com.example.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String urlPhoto;
	@ManyToMany
	private Set<Album> album;
	// getters and setters
	public int getId() {
		return id;
	}
	public Set<Album> getAlbum() {
		return album;
	}
	public void setAlbum(Set<Album> album) {
		this.album = album;
	}
	public String getUrlCover() {
		return urlPhoto;
	}
	public void setUrlCover(String urlCover) {
		this.urlPhoto = urlCover;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
