package com.CodingDojo.Classy.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.Classy.models.Course;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {
	
	
	Optional<Course> findById(Long id);
	Course findByTitle(String title);	
	List<Course> findAllByInstructor(String instructor);
	List<Course> findAllByMax(int max);
	List<Course> findAll();
	
}
