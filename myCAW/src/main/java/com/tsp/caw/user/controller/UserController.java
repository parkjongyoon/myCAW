package com.tsp.caw.user.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tsp.caw.config.CustomAuthenticationProvider;
import com.tsp.caw.user.dto.UserDTO;
import com.tsp.caw.user.service.UserService;

@Controller
public class UserController {

	private static final Log LOG = LogFactory.getLog( UserController.class );
	
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
	
	@GetMapping("/login")
	public String login(Model model) {
		return "user/login";
	}
	
	@GetMapping("/users")
	public String readUsers(Model model) {
		return "user/list";
	}
}
