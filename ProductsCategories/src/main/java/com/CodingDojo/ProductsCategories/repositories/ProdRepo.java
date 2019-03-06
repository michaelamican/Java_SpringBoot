package com.CodingDojo.ProductsCategories.repositories;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.ProductsCategories.models.Product;


@Repository
public interface ProdRepo extends CrudRepository<Product, Long>{
	void deleteById(Long id);
	List<Product> findAll();
	List<Product> findByNameNotIn(List<String> names);
}
