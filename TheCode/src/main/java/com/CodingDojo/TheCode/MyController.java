package com.CodingDojo.TheCode;

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
	@RequestMapping(value="/bushibushi", method=RequestMethod.POST)
	public String bushibushi(@RequestParam(value="code") String code) {
		if(code.equals("bushido")) {
			return "redirect:/access";
		} else {
			return "redirect:/whoops";
		}
	}
	@RequestMapping("/whoops")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You are WRONG. WRONG I SAY.");
		return "redirect:/";
	}
	@RequestMapping("/access")
	public String access() {
		return "access.jsp";
	}
}