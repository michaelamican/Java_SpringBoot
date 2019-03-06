package com.CodingDojo.DojoOverflow.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.DojoOverflow.models.User;

public interface UserRepo extends CrudRepository<User, Long> {

	User findByEmail(String email);
	Optional<User> findById(Long id);
}
