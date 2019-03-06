package com.CodingDojo.Lookify.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import com.CodingDojo.Lookify.models.Song;
import com.CodingDojo.Lookify.repositories.SongRepository;


@Service
public class SongService {
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> searchByTitle(String search){
		return songRepository.findAllByTitleContaining(search);
	}
	
	public List<Song> searchByArtist(String search){
		return songRepository.findAllByArtistContaining(search);
	}
	
	public List<Song> allSongs(){
		return songRepository.findAll();
	}
	public List<Song> sortedSongs(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Song createSong(Song repo) {
		return songRepository.save(repo);
	}
	//Find by id
	public Song findSong(Long id) {
		Optional<Song> thatSong = songRepository.findById(id);
		if(thatSong.isPresent()) {
			return thatSong.get();
		} else{ 
			return null;
		}
	}
	//Update
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}
	//Delete
	public void deleteSong(Long id) {
		Optional<Song> thatSong = songRepository.findById(id);
		if(thatSong.isPresent()) {
			songRepository.deleteById(id);
		} else {
			System.out.println("Song not in repo");
		}
	}
	

}
