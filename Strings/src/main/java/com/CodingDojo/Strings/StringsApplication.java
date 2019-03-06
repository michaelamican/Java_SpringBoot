package com.CodingDojo.Strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	@RequestMapping("/")
	public String hello() {
		return "<h1>Hello there! How are you?</h1><h3><a href='/random'>Click here to find out</a></h3>";
	}
	@RequestMapping("/random")
	public String random() {
		return "<h1>Fabulous!</h1><h3><a href='/'>Click here to go back</a></h3>";
	}
		
	
}
