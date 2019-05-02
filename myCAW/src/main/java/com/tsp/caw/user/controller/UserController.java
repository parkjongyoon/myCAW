package com.tsp.caw.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tsp.caw.user.dto.UserDTO;
import com.tsp.caw.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String joinForm(Model model) {
		return "user/join";
	}
	
	@PostMapping("/register")
	public String createtUser(Model model, UserDTO userDTO) {
		userService.createUser(userDTO);
		return "redirect:/users";
	}
	
	@GetMapping("/users")
	public String readUsers(Model model) {
		return "user/list";
	}
}
