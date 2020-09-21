package com.xantrix.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DipendenteController {

	@GetMapping("home")
	public String allDipedenti(Model model) {
		
		return "home";
		
	}
	
	@GetMapping(value="/login")
	public String getLogin(Model model) {
		
		return "login";
	}

	
	@GetMapping(value="/dipendenti")
	public String getDettDipendenti(Model model) {
		
		return "dipendenti";
	}

	
}
