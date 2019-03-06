package com.CodingDojo.Lookify.models;

import javax.persistence.Entity;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//import java.sql.Array;
//import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;




@Entity
@Table(name="songs")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 255)
	private String title;
	private int rating;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	@Size(min = 2, max = 255)
	private String artist;

	public Song() {
	}
	public Song(String artist, String title, int rating) {
		this.artist = artist;
		this.title = title;
		this.rating = rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
