package com.example.demo.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.impl.UserService;

@Controller
public class LoginController {
		@Autowired
		@Qualifier("userService")
		private UserService userService;
		@Autowired
		@Qualifier("usuarioService")
		private UsuarioService usuarioService;
		@GetMapping("/auth/login")
		public String login(Model model,@RequestParam(name="error",required=false) String error,
				@RequestParam(name="logout",required=false) String logout) {
				try {
					model.addAttribute("user",new User());
					model.addAttribute("error",error);
					model.addAttribute("logout",logout);
					
				}catch (Exception e) {
					// TODO: handle exception
				}
				return "login";
		}
		
		@GetMapping("/registro")
		public String registerForm(Model model) {
			model.addAttribute("user",new User());
		
			
			return "registro";
		}
		@PostMapping("/registro")
		public String register(@Valid @ModelAttribute User user,BindingResult result,RedirectAttributes flash,@RequestParam("file") MultipartFile foto) {
			 if (result.hasErrors()) {			
				 return "registro";
			 }
			 else {
				 if (!usuarioService.existeEmail(user.getEmail())) {
					 if(!foto.isEmpty()) {
						 Path directorioImagenes=Paths.get("src//main//resources//static/imgs");
						 String rutaAbsoluta=directorioImagenes.toFile().getAbsolutePath();
						 try {
							byte[] bytesfoto=foto.getBytes();
							Path rutaCompleta=Paths.get(rutaAbsoluta+"//"+foto.getOriginalFilename());
							Files.write(rutaCompleta, bytesfoto);
						} catch (IOException e) {
							System.err.print("Ha ocurrido un error");
							e.printStackTrace();
						}
						 
					 }
					 user.setFoto(foto.getOriginalFilename());
					 userService.registrar(user);
					 flash.addFlashAttribute("success", "Usuario registrado correctamente!");
					 return "redirect:/auth/login"; 
				 }else {
					 flash.addFlashAttribute("success", "Email duplicado");
					 return "redirect:/registro"; 
				 }
				
			 }
			
		}
		
		
}
