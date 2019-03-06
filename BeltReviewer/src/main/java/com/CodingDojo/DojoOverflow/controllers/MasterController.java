package com.CodingDojo.DojoOverflow.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CodingDojo.DojoOverflow.services.MasterService;

import com.CodingDojo.DojoOverflow.models.User;
import com.CodingDojo.DojoOverflow.models.UserEvent;
import com.CodingDojo.DojoOverflow.models.Event;

@Controller
public class MasterController {
	private final MasterService mS;
	
	public MasterController(MasterService mS) {
		this.mS = mS;
	}
	@GetMapping("/")
	public String intro() {
		return "start.jsp";
	}
	
	@RequestMapping("/enter")
	public String enter(@ModelAttribute("newUser") User user) {
		return "loginreg.jsp";
	}
	@PostMapping("/login")
	public String checkUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = mS.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = mS.findByEmail(email);
			session.setAttribute("userId",u.getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "loginreg.jsp";
		}
	}
	@PostMapping("/registerUser")
	public String createUser(@Valid @ModelAttribute("newUser") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("Errors!");
			return "loginreg.jsp";
		} else {
			//create User
			mS.createUser(user);
			session.setAttribute("userId", user.getId());
			return "redirect:/home";
		}
	}
	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		User u = mS.findUserById(userId);
		model.addAttribute("user", u);
		return "home.jsp";
	}
	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("newEvent") Event event, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Errors!");
			return "home.jsp";
		} else {
			//create Event
			mS.createEvent(event);
			return "home.jsp";
		}
	}
	@GetMapping("/user/{uId}")
	public String showUser(@PathVariable("uId") Long id, Model model) {
		User u = mS.getUserById(id);
		model.addAttribute("user", u);
		return "edituser.jsp";
	}
	@GetMapping("/events/{eId}")
	public String showEvent(@ModelAttribute("comment")UserEvent comment, @PathVariable("eId") Long id, Model model) {
		Event e = mS.getEventById(id);
		model.addAttribute("event", e);
		return "show.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
