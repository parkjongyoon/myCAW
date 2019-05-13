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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tsp.caw.user.service.UserService;
import com.tsp.caw.user.vo.UserVo;

@Controller
public class UserController {

	private static final Log LOG = LogFactory.getLog( UserController.class );
	
	@Autowired
	private UserService userService;
	
	/**
	 * 회원 등록폼
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@GetMapping("/register")
	public String insertUserForm(Model model) {
		return "user/join";
	}
	
	/**
	 * 회원 등록하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@PostMapping("/register")
	public String insertUser(Model model, UserVo userVo) {
		userService.insertUser(userVo);
		return "redirect:/admin/user/users";
	}
	
	/**
	 * 로그인하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@GetMapping("/login")
	public String login(Model model) {
		return "user/login";
	}
	
	/**
	 * 로그아웃하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
	
	/**
	 * 회원 리스트 가져오기(ajax)
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@GetMapping("/admin/user/users-json")
	@ResponseBody
	public List<UserVo> selectUserByAjax(Model model) {
		UserVo userVo = new UserVo();
		return userService.selectUserByCondition(userVo);
	}
	
	/**
	 * 회원 리스트
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@GetMapping("/admin/user/users")
	public String selectUserByCondition(Model model) {
		return "user/list";
	}
	
	/**
	 * 회원 수정폼
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@GetMapping("/admin/user/users/{userSeq}")
	public String updateUserForm(Model model, @PathVariable int userSeq) {
		UserVo userVo = userService.selectUserByUserSeq(userSeq);
		model.addAttribute("userVo", userVo);
		return "/user/edit";
	}
	
	/**
	 * 회원 수정하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@PostMapping("/admin/user/users/{userSeq}")
	public String updateUser(Model model, UserVo userVo, @PathVariable int userSeq) {
		userService.updateUser(userVo);
		return "redirect:/admin/user/users";
	}
	
	/**
	 * 회원 삭제하기
	 *  
	 * @author jongyoon.park
	 * @since 2019. 5. 13.
	 */
	@DeleteMapping("/admin/user/users/{userSeq}")
	public String deleteUser(Model model, @PathVariable int userSeq) {
		userService.deleteUser(userSeq);
		return "redirect:/admin/user/users";
	}
}
