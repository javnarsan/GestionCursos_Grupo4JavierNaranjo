package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping({"/","inicio"})
	public String insertarTituloPestaña(Model model) {
		String titulo="inicio";
		model.addAttribute("titulo",titulo);
		return "index";
	}

}
