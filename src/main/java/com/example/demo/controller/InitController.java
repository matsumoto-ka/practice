package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {

	/*
	 * private final UserService userService;
	 * 
	 * // shianServiceのDI public InitController(UserService userService) {
	 * this.userService = userService; }
	 */

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
}