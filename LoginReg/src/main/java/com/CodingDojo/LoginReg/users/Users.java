//package com.CodingDojo.LoginReg.users;
//
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.CodingDojo.LoginReg.models.User;
//import com.CodingDojo.LoginReg.services.UserService;
//
//@Controller
//public class Users {
//	private final UserService userService;
//	
//	public Users(UserService userService) {
//		this.userService = userService;
//	}
//	
//	@GetMapping("/registration")
//	public String registerForm(@ModelAttribute("user") User user) {
//		return "registrationPage.jsp";
//	}
//	@GetMapping("/login")
//	public String login() {
//		return "loginPage.jsp";
//	}
//	@PostMapping("/registration")
//	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//		if(result.hasErrors()) {
//			return "registrationPage.jsp";
//		}
//		User u = userService.registerUser(u);
//		session.setAttribute("userId",  u.getId());
//		return "redirect:/home";
//	}
//	
//	@PostMapping("/login")
//	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
//		boolean isAuthenticated = userService.authenticateUser(email, password);
//		if(isAuthenticated) {
//			User u = userService.findByEmail(email);
//			session.setAttribute("userId",  u.getId());
//			return "redirect:/home";;
//		} else {
//			model.addAttribute("error", "Invalid Credentials. Please try again.");
//			return "loginPage.jsp";
//		}				
//	}
//	@GetMapping("/home")
//	public String home(HttpSession session, Model model) {
//		//get user from session, save them in model, return home page
//		
//		return "redirect:/home"; 
//	}
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		//invalidate session
//		//redirect to login
//		return "redirect:/";
//	}
//}
