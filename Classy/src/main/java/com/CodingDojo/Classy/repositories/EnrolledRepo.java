package com.CodingDojo.Classy.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.Classy.models.Enrolled;

@Repository
public interface EnrolledRepo extends CrudRepository<Enrolled, Long> {
	Optional<Enrolled> findAllByUserId(Long id);
	Optional<Enrolled> findAllByCourseId(Long id);
	List<Enrolled> findAll();
	
}
