package com.CodingDojo.ShowReviewer.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.ShowReviewer.models.Rating;

@Repository
public interface RatingRepo extends CrudRepository<Rating, Long>{

	Optional<Rating> findAllByShowId(Long id);

}
