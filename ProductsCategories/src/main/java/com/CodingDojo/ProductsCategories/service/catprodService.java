package com.CodingDojo.ProductsCategories.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.CodingDojo.ProductsCategories.models.User;


import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.CodingDojo.ProductsCategories.models.Category;
import com.CodingDojo.ProductsCategories.models.CategoryProduct;
import com.CodingDojo.ProductsCategories.models.Product;
import com.CodingDojo.ProductsCategories.repositories.CatProdRepo;
import com.CodingDojo.ProductsCategories.repositories.CatRepo;
import com.CodingDojo.ProductsCategories.repositories.ProdRepo;
import com.CodingDojo.ProductsCategories.repositories.UserRepo;

@Service
public class catprodService {
	private final ProdRepo pR;
	private final CatRepo cR;
	private final CatProdRepo cpR;
	private final UserRepo uR;
	
	public catprodService(ProdRepo pR, CatRepo cR, CatProdRepo cpR, UserRepo uR) {
		this.pR = pR;
		this.cR = cR;
		this.cpR = cpR;
		this.uR = uR;
	}
	
	//CREATE -----------------------------------------------------------------------------------------------
	public Product createProduct(Product product) {
		return pR.save(product);
	}
	public Category createCategory(Category category) {
		return cR.save(category);
	}
	public void createProductCategory(CategoryProduct categoryproduct) {
		cpR.save(categoryproduct);
	}
	//SHOW BY ID -----------------------------------------------------------------------------------------------
	public Product getProductById(Long id) {
		Optional<Product> product = pR.findById(id);
		if(product.isPresent()) {
			return product.get();
		} else {
			System.out.println("Does not exist");
			return null;
		}
	}
	public Category getCategoryById(Long id) {
		Optional<Category> category = cR.findById(id);
		if(category.isPresent()) {
			return category.get();
		} else {
			System.out.println("Does not exist");
			return null;
		}
	}
	// SHOW ASSOCIATED  -----------------------------------------------------------------------------------------------
	public List<Category> getAvailableCategories(Product p) {
		List<Category> currentCats=p.getCategories();
		List<String> names = new ArrayList<String>();
		if(currentCats.size() ==0) {
			names.add("");
		}
		for(Category c : currentCats) {
			names.add(c.getName());
		}
		System.out.println(names);
		return cR.findByNameNotIn(names);
	}
	public List<Product> getAvailableProducts(Category c) {
		List<Product> currentProds=c.getProducts();
		List<String> names = new ArrayList<String>();
		if(currentProds.size() ==0) {
			names.add("");
		}
		for(Product p : currentProds) {
			names.add(p.getName());
		}
		System.out.println(names);
		return pR.findByNameNotIn(names);
	}
	// SHOW ALL  -----------------------------------------------------------------------------------------------
	public List<Product> getAllProducts(){
		List<Product> product = pR.findAll();
		return product;
	}
	public List<Category> getAllCategories() {
		List<Category> category = cR.findAll();
		return category;
	}
	//UPDATE   -----------------------------------------------------------------------------------------------
	public void updateProduct(@Valid Product product, Long id) {
		Optional<Product> q = pR.findById(id);
		Product p = q.get();
		p.setName(product.getName());
		p.setPrice(product.getPrice());
		p.setDescription(product.getDescription());
		pR.save(p);
	}
	public void updateCategory(@Valid Category category) {
		cR.save(category);
	}
	//DELETE   -----------------------------------------------------------------------------------------------
	public void deleteProduct(Long id) {
		pR.deleteById(id);
	}

	public void deleteCategory(Long id) {
		cR.deleteById(id);
		
	}

	public void deleteCategoryProduct(Long id) {
		cpR.deleteById(id);
	}
	//LOGIN REG   -----------------------------------------------------------------------------------------------
	
	//register and hash
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uR.save(user);
	}
	
	//find by email
	public User findByEmails(String email) {
		return uR.findByEmail(email);
	}
	
	//find by user id
	public User findUserById(Long id) {
		Optional<User> u = uR.findById(id);
		if(u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	
	//authenticate user
	public boolean authenticateUser(String email, String password) {
		//find by email first
		User user = uR.findByEmail(email);
		//if we can't, return false
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}



}
