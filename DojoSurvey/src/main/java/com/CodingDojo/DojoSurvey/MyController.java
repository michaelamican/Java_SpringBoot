package com.CodingDojo.DojoSurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController{
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/submits")
	public String submission(HttpSession session, @RequestParam(value="name")String name, @RequestParam(value="location") String location, @RequestParam(value="language")String language, @RequestParam(value="comment")String comment) {
		if(name.equals(null)) {
			return "redirect:/whoops";
		} else if(location.equals("noVal")){
			return "redirect:/whoops";
		} else if(language.equals("noVal")) {
			return "redirect:/whoops";
		} else {
			if(language.equals("Java")) {
				session.setAttribute("name", name);
				session.setAttribute("location", location);
				session.setAttribute("language", language);
				if(comment.equals(null)) {
				session.setAttribute("comment", "No comment");
					
				} else {
					session.setAttribute("comment", comment);
				}
				return "redirect:/java";	
			} else {
				session.setAttribute("name", name);
				session.setAttribute("location", location);
				session.setAttribute("language", language);
				if(comment.equals(null)) {
					session.setAttribute("comment","No comment");
					
				} else {
					session.setAttribute("comment", comment);
				}
			}
			return "redirect:/result";	
		}
	}
	
	@RequestMapping("/whoops")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Something went wrong.");
		return "redirect:/";
	}
	@RequestMapping("/java")
	public String java(HttpSession session) {
		return "java.jsp";
	}
	@RequestMapping("/result")
	public String result(HttpSession session) {
		return "result.jsp";
	}
}