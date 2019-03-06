package com.CodingDojo.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.ProductsCategories.models.Category;


@Repository
public interface CatRepo extends CrudRepository<Category, Long> {
	void deleteById(Long id);
	List<Category> findAll();
	List<Category> findByNameNotIn(List<String> names);
	
}
