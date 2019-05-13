package com.tsp.caw.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsp.caw.user.service.UserService;
import com.tsp.caw.user.vo.UserVo;

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
	public String createtUser(Model model, UserVo userVo) {
		userService.createUser(userVo);
		return "redirect:/admin/user/users";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
	
	@GetMapping("/admin/user/users-json")
	@ResponseBody
	public List<UserVo> readUsers(Model model) {
		return userService.readUser();
	}
	
	@GetMapping("/admin/user/users")
	public String userList(Model model) {
		return "user/list";
	}
}
