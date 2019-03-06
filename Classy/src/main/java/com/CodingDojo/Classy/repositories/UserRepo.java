package com.CodingDojo.Classy.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.Classy.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	User findByEmail(String email);
	Optional<User> findById(Long id);
	List<User> findAll();
	List<User> findByNameIn(List<String> names);
}
