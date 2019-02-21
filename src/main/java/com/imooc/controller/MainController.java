package com.imooc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.imooc.domain.Authority;
import com.imooc.domain.User;
import com.imooc.service.AuthorityService;
import com.imooc.service.UserService;

@Controller
public class MainController {

	private static final Long ROLE_USER_AUTHORITY_ID=2L;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorityService authorityService;
	
	//重定向
	@GetMapping("/")
	public String root(){
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index(){
		return "redirect:/blogs";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
		
	@GetMapping("/register")
	public String register(){
		return "register";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model){
		model.addAttribute("loginError",true);
		model.addAttribute("errorMsg","登陆失败,用户名或密码错误!");
		return "login";
	}
	
	@PostMapping("/register")
	public String registerUser(User user){
		List<Authority> authorities=new ArrayList<>();
		authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
		user.setAuthorities(authorities);
		userService.registerUser(user);
		return "redirect:/login";
	}
	
}
