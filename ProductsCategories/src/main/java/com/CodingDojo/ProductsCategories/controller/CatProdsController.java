package com.CodingDojo.ProductsCategories.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodingDojo.ProductsCategories.models.Category;
import com.CodingDojo.ProductsCategories.models.CategoryProduct;
import com.CodingDojo.ProductsCategories.models.Product;
import com.CodingDojo.ProductsCategories.models.User;
import com.CodingDojo.ProductsCategories.service.catprodService;

@Controller
public class CatProdsController {
	
	private final catprodService cpS;
	public CatProdsController(catprodService cpS) {
		this.cpS = cpS;
	}
	@GetMapping("/")
	public String enter(@ModelAttribute ("newUser") User user, BindingResult result) {
		return "welcome.jsp";
	}
	@GetMapping("/dashboard")
	public String dash(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			System.out.println("Hit dashboard, no ID in session");
			return "redirect:/";
		}
		model.addAttribute("product", cpS.getAllProducts());
		model.addAttribute("category", cpS.getAllCategories());
		return "dash.jsp";
	}

//CRUD -----------------------------------------------------------------------------------------------------
	//CREATE -----------------------------------------------------------------------------------------------
	@GetMapping("/createProduct")
	public String newProduct(@ModelAttribute("productObj")Product product, @ModelAttribute("catObj") Category category, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		//Create page
		return "create.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("productObj") Product product, @ModelAttribute("catObj") Category category, BindingResult result, @RequestParam("name") String n, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		if(result.hasErrors()) {
			return "create.jsp";
		} else {
		//Creates product
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			Product p = cpS.createProduct(product);
		return "redirect:/products/"+p.getId();
		}
	}
	@PostMapping("/categories/new")
	public String createCategory(@Valid  @ModelAttribute("catObj") Category category, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		if(result.hasErrors()) {
			return "create.jsp";
		} else {
		//Creates category
			System.out.println(category.getName());
			Category c = cpS.createCategory(category);
		return "redirect:/categories/"+c.getId();
		}
	}

	//READ -----------------------------------------------------------------------------------------------
	@GetMapping("/categories/{cId}")
	public String showCategory(@ModelAttribute("cpObj")CategoryProduct cp, @PathVariable("cId") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		Category c = cpS.getCategoryById(id);
		model.addAttribute("category", c);
		model.addAttribute("allProds", cpS.getAvailableProducts(c));
		return "show.jsp";
	}
	@GetMapping("/products/{pId}")
	public String showProduct(@ModelAttribute("cpObj")CategoryProduct cp, @PathVariable("pId") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		Product p = cpS.getProductById(id);
		model.addAttribute("product", p);
		model.addAttribute("allCats", cpS.getAvailableCategories(p));
		return "show.jsp";
	}
	
//UPDATE -----------------------------------------------------------------------------------------------
	@PostMapping("/addCategory")
	public String addCategory(@ModelAttribute("cpObj") CategoryProduct cp, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		cpS.createProductCategory(cp);
		return "redirect:/products/" + cp.getProduct().getId();
	}
	//GET --------------------------------------------------
	@GetMapping("/edit/{pId}")
	public String editProduct(@ModelAttribute("cpObj")CategoryProduct cp, @PathVariable("pId") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		Product p = cpS.getProductById(id);
		model.addAttribute("product", p);
		model.addAttribute("allCats", cpS.getAvailableCategories(p));
		return "edit.jsp";
	}
	@GetMapping("/editCat/{cId}")
	public String editCategory(@ModelAttribute("cpObj")CategoryProduct cp, @PathVariable("cId") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		Category c = cpS.getCategoryById(id);
		model.addAttribute("category", c);
		return "edit.jsp";
	}
//PUT -------------------------------------------------------
	@PutMapping("/update/{pId}")
	public String updateProduct(@Valid @ModelAttribute("product")Product product,@PathVariable("pId") Long id, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			
			cpS.updateProduct(product, id);
			return "redirect:/products/"+id;
		}
	}
	@PutMapping("/updateCat/{cId}")
	public String updateCategory(@Valid @ModelAttribute("category")Category category, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			cpS.updateCategory(category);
			return "redirect:/category/"+category.getId();
		}
	}

//DELETE -----------------------------------------------------------------------------------------------
	@DeleteMapping("/delete/{pId}")
	public String deleteProduct(@PathVariable("pId") Long id, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		} 
		cpS.deleteProduct(id);
		return "redirect:/";
	}
//	@DeleteMapping("/deleteCat/{cId}")
//	public String deleteCategory(@PathVariable("cId") Long id) {
//		cpS.deleteCategory(id);
//		return "redirect:/";
//	}
//	@DeleteMapping("/deleteCatProd/{cpId}")
//	public String deleteCategoryProduct(@PathVariable("cpId") Long id) {
//		cpS.deleteCategoryProduct(id);
//		return "redirect:/";
//	}


//LOGINREG -----------------------------------------------------------------------------------------------

	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "welcome.jsp";
		}
		User u = cpS.registerUser(user);
		session.setAttribute("userId",  u.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, @ModelAttribute("newUser")User user, BindingResult result, Model model, HttpSession session) {
		boolean isAuthenticated = cpS.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = cpS.findByEmails(email);
			session.setAttribute("userId", u.getId());
			System.out.println("userId: " + u.getId().toString());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "welcome.jsp";
		}				
	}
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User u = cpS.findUserById(userId);
		model.addAttribute("user", u);
		return "redirect:/dashboard"; 
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}			
}
	
