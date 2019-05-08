package com.tsp.caw.user.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("/admin/users")
	@ResponseBody
	public List<UserDTO> readUsers(Model model) {
		return userService.readUser();
	}
	
	@GetMapping("/admin/user-list")
	public String userList(Model model) {
		return "user/list";
	}
}
