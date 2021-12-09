package com.questionadosfm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questionadosfm")
public class QuestionadosController {

	@GetMapping(path = "/all")
	public String all() {
		return "Showing public content";
	}
	
	@GetMapping(path = "/users")
	public String users() {
		return "Showing content for USERS, MODERATORS and ADMINS";
	}
	
	@GetMapping(path = "/mod")
	public String mod() {
		return "Showing content for MODERATORS";
	}
	
	@GetMapping(path = "/admin")
	public String admin() {
		return "Showing content for ADMINS";
	}
}
