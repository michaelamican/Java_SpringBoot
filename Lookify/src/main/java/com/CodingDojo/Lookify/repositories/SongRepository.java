package com.CodingDojo.Lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.Lookify.models.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	List<Song> findAll();
	List<Song> findAllByTitleContaining(String search);
	List<Song> findAllByArtistContaining(String search);
	void deleteById(Long id);
	Long countByTitleContaining(String search);
	Long deleteByTitleStartingWith(String search);
	List<Song> findTop10ByOrderByRatingDesc();
}
