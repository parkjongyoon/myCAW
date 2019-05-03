package com.tsp.caw.user.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/")
	public String main() {
		return "hello world";
	}
	
	@GetMapping("/call")
	public String callMain(Model model) {
		return "call/main";
	}	
}
