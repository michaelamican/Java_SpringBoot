package com.CodingDojo.ShowReviewer.controller;

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

import com.CodingDojo.ShowReviewer.models.Show;
import com.CodingDojo.ShowReviewer.models.Rating;
import com.CodingDojo.ShowReviewer.models.User;
import com.CodingDojo.ShowReviewer.service.MasterService;

@Controller
public class MasterController {
	
	private final MasterService mS;
	public MasterController(MasterService mS) {
		this.mS = mS;
	}
	
	


//RESTful (Get Requests)====================================================================================================================================
	
	@GetMapping("/")
	public String welcome(@ModelAttribute("userObj")User user, BindingResult result, Model model) {
		model.addAttribute("errors", "Invalid");
		return "login.jsp";
	}
	
	@GetMapping("/shows")
	public String home(@ModelAttribute("userObj") User user, HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
        }
		Long id = (Long) session.getAttribute("userId");
		model.addAttribute("show", mS.getAllShows());
		model.addAttribute("user", mS.findUserById(id));
		return "home.jsp";
	}
	@GetMapping("/shows/{sId}")
	public String showShow(@ModelAttribute("showObj")Show show, @ModelAttribute("rObj")Rating rating, @PathVariable("sId")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Long userId = (Long) session.getAttribute("userId");
		User u = mS.getUserById(userId);
		Show s = mS.getShowById(id);
//		Rating r = mS.getRatings(s.getId());
//			if(r == null) {
//				Rating x = new Rating();
//				x.setShow(s);
//				x.setUser(mS.findUserById(userId));
//				x.setRating(5);
//				r.setShow(x.getShow());
//				r.setUser(x.getUser());
//				r.setRating(x.getRating());
//				mS.deleteRating(x);
//			}
//      model.addAttribute("rating", r);
		model.addAttribute("show", s);

        model.addAttribute("user", u);
		return "view.jsp";
    }
    
//CRUD ====================================================================================================================================
	//CREATE ====================================================================================================================================
	
	@GetMapping("/shows/new")
	public String newShow(@ModelAttribute("showObj")Show show, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/shows";
		}
		return "create.jsp";
	}
	@PostMapping("/create")
	public String createShow(@Valid @ModelAttribute("showObj")Show show, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "create.jsp";
		} else {
			Show s = mS.createShow(show);
			return "redirect:/shows/"+s.getId();
		}
	}
	//READ ====================================================================================================================================
	@GetMapping("/shows/{sId}/edit")
	public String editShow(@PathVariable("sId") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Show s = mS.getShowById(id);
		model.addAttribute("showId", id);
		model.addAttribute("showTitle", s.getTitle());
		model.addAttribute("showObj", s);
		return "edit.jsp";
	}
		
	//UPDATE ====================================================================================================================================
	@PutMapping("/update/{sId}")
	public String updateShow(@Valid @ModelAttribute("showObj") Show show, BindingResult result, @PathVariable("sId")Long id, Model model, HttpSession session) {
	if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Show s = mS.getShowById(id);
			model.addAttribute("showId", id);
			model.addAttribute("showTitle", s.getTitle());
			return "edit.jsp";
		} else {
			mS.updateShow(show, id);
		return "redirect:/shows/" + id;
		}
	}
	@PostMapping("/rate")
	public String addShow(@ModelAttribute("rObj") Rating r, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		else {
			mS.rate(r);
			return "redirect:/shows";
		}
	}
	//DELETE ====================================================================================================================================
	@DeleteMapping("/delete/{sId}")
	public String deleteShow(@PathVariable("sId")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		} mS.deleteShow(id);
		return "redirect:/shows";
	}

//LOGIN-REG ====================================================================================================================================
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("error", model);
			return "login.jsp";
		}
		User u = mS.makeUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/shows";
	}
	
	@PostMapping("/login")
	public String loginUser(@Valid @ModelAttribute("userObj")User user, BindingResult result, @RequestParam("email")String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = mS.checkUser(email, password);
		if(isAuthenticated) {
			User u = mS.findByEmails(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/shows";
		} else {
			model.addAttribute("error", "Invalid Credentials. Please try again.");
			return "login.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
