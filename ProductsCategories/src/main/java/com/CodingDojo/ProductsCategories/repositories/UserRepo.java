package com.CodingDojo.ProductsCategories.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.ProductsCategories.models.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	User findByEmail(String email);
	Optional<User> findById(Long id);
}
