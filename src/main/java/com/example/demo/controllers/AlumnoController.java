package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.UserModel;
import com.example.demo.services.UsuarioService;

@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/alumno")
public class AlumnoController {
	private static final String FORMPERSONAL_VIEW = "formPersonal";

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;

	@GetMapping(value = { "/formPersonal/{email}" })
	public String formProfesor(@PathVariable(name = "email", required = false) String email, Model model) {
		model.addAttribute("personal", usuarioService.findUserByEmail(email));
		return FORMPERSONAL_VIEW;
	}

	@PutMapping("/addPersonal")
	public String addPersonal(@ModelAttribute("personal") UserModel personalModel, RedirectAttributes flash,
			BindingResult result) {
		if (result.hasErrors()) {
			return FORMPERSONAL_VIEW;
		} else {
			usuarioService.updateAlumno(personalModel);
			flash.addFlashAttribute("success", "Perfil modificado exitosamente");
		}
		return "redirect:/";

	}
}
