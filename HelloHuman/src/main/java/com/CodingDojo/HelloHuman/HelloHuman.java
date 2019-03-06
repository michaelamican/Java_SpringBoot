package com.CodingDojo.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
	public class HelloHuman {
		@RequestMapping("/")
		public String index(@RequestParam(value="name", required = false) String searchQuery) {
			if(searchQuery == null) {
				return "<h1>Hello Human!</h1><br><h4>Welcome to SpringBoot!</h4>";
			} else {
			return "<h1>Hello " + searchQuery +"!</h1><br><h4>Welcome to SpringBoot!</h4><h5><a href='/'>Go Back</a></h5>";
			}
		}
	}

