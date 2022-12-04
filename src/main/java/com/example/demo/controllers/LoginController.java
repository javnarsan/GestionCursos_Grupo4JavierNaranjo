package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.services.impl.UserService;

@Controller
public class LoginController {
		@Autowired
		@Qualifier("userService")
		private UserService userService;
		@GetMapping("/loguearse")
		public String login(Model model,@RequestParam(name="error",required=false) String error,
				@RequestParam(name="logout",required=false) String logout) {
					model.addAttribute("user",new User());
					model.addAttribute("error",error);
					model.addAttribute("logout",logout);
					return "login";
			
		}
		@GetMapping("/registro")
		public String registerForm(Model model) {
			model.addAttribute("user",new User());
		
			
			return "registro";
		}
		@PostMapping("/registro")
		public String register(@ModelAttribute User user,RedirectAttributes flash) {
			userService.registrar(user);
			flash.addFlashAttribute("success", "User register sucesfully!");
			return "redirect:/resgistro";
		}
		
		
}
