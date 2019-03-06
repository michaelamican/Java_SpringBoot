package com.CodingDojo.GettingFamiliar;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


@RequestMapping("/coding")
public class HomeController {
	@RequestMapping("")
	public String index() {
		return "<h1>Hello Coding Dojo!</h1><h3><a href='/coding/java'>Java</a></h3><h3><a href='/coding/python>Python</a></h3>";
	}
	@RequestMapping("/{word}")
	public String awesome(@PathVariable("word") String word) {
		return "The "+word+" is awesome!";
	}
	@RequestMapping("/java")
	public String java() {
		return "<h1>Java is better!</h1><h3><a href='/coding'>Home</a></h3><h3><a href='/coding/python>Python</a></h3>";
	}

@RequestMapping("/{location}-dojo")
	public String location(@PathVariable("location") String location) {
		return location + " is located in SoCal";
		
	}

@RequestMapping("/dojo/{first}-{last}")
	public String first(@PathVariable("first") String first,  @PathVariable("last") String last) {
	return first +" "+ last + " is the headquarters";
	}
}
