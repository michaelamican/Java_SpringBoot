package com.CodingDojo.Classy.controller;

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

import com.CodingDojo.Classy.models.Course;
import com.CodingDojo.Classy.models.Enrolled;
import com.CodingDojo.Classy.models.User;
import com.CodingDojo.Classy.service.MasterService;

@Controller
public class MasterController {
	
	private final MasterService mS;
	public MasterController(MasterService mS) {
		this.mS = mS;
	}
	
	


//RESTful (Get Requests)====================================================================================================================================
	
	@GetMapping("/")
	public String welcome(@ModelAttribute("userObj")User user, BindingResult result) {
		return "login.jsp";
	}
	
	@GetMapping("/courses")
	public String home(HttpSession session, Model model, @ModelAttribute("eObj") Enrolled e) {
		Long userId = (Long) session.getAttribute("userId");
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		User u = mS.findUserById(userId);
		model.addAttribute("course", mS.getAllCourses());
		model.addAttribute("user", u);
		return "home.jsp";
	}
	@GetMapping("/courses/{cId}")
	public String showCourse(@ModelAttribute("courseObj")Course course, @PathVariable("cId")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Course c = mS.getCourseById(id);
		model.addAttribute("course", c);
		model.addAttribute("enrolled", mS.getEnrolledStudents(id));
		return "show.jsp";
	}
//CRUD ====================================================================================================================================
	//CREATE ====================================================================================================================================
	
	@GetMapping("/courses/new")
	public String newCourse(@ModelAttribute("courseObj")Course course, @ModelAttribute("userObj")User user, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/courses";
		}
		return "create.jsp";
	}
	@PostMapping("/create")
	public String createCourse(@Valid @ModelAttribute("courseObj")Course course, BindingResult result, @ModelAttribute("userObj")User user, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "create.jsp";
		} else {
			System.out.println(course.getTitle());
			System.out.println(course.getInstructor());
			System.out.println(course.getMax());
			Course c = mS.createCourse(course);
			return "redirect:/courses/"+c.getId();
		}
	}
	//READ ====================================================================================================================================
	@GetMapping("/courses/{cId}/edit")
	public String editCourse(@PathVariable("cId") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Course c = mS.getCourseById(id);
		model.addAttribute("courseId", id);
		model.addAttribute("courseTitle", c.getTitle());
		model.addAttribute("courseObj", c);
		model.addAttribute("enrolled", mS.getEnrolledStudents(id));
		return "edit.jsp";
	}
		
	//UPDATE ====================================================================================================================================
	@PutMapping("/update/{cId}")
	public String updateCourse(@Valid @ModelAttribute("courseObj") Course course, BindingResult result, @PathVariable("cId")Long id, Model model, HttpSession session) {
	if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			Course c = mS.getCourseById(id);
			model.addAttribute("courseId", id);
			model.addAttribute("courseTitle", c.getTitle());
			model.addAttribute("enrolled", mS.getEnrolledStudents(id));
			return "edit.jsp";
		} else {
			mS.updateCourse(course, id);
		return "redirect:/courses/" + id;
		}
	}
	@PostMapping("/enroll")
	public String addCourse(@ModelAttribute("eObj") Enrolled e, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		else {
			mS.enroll(e);
			return "redirect:/courses";
		}
	}
	//DELETE ====================================================================================================================================
	@DeleteMapping("/delete/{cId}")
	public String deleteCourse(@PathVariable("cId")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		} mS.deleteCourse(id);
		return "redirect:/courses";
	}
//LOGIN-REG ====================================================================================================================================
	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("error", "Invalid.");
			return "login.jsp";
		}
		User u = mS.makeUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/courses";
	}
	
	@PostMapping("/login")
	public String loginUser(@Valid @RequestParam("email")String email, @RequestParam("password") String password,  Model model, HttpSession session) {
		boolean isAuthenticated = mS.checkUser(email, password);
		if(isAuthenticated) {
			User u = mS.findByEmails(email);
			session.setAttribute("userId", u.getId());
			System.out.println("UserId: "+u.getId().toString());
			return "redirect:/courses";
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
