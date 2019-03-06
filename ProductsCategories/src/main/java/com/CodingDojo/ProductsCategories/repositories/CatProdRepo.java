package com.CodingDojo.ProductsCategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CodingDojo.ProductsCategories.models.CategoryProduct;


@Repository
public interface CatProdRepo extends CrudRepository<CategoryProduct, Long>{
	List<CategoryProduct> findAll();
}
