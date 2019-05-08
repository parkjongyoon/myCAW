package com.tsp.caw;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String main(Model model) {
		return "main";
	}
	
	@GetMapping("/call")
	public String callMain(Model model) {
		return "call/main";
	}	
	
	@GetMapping("/admin")
	public String adminMain(Model model) {
		return "admin/main";
	}	
}
