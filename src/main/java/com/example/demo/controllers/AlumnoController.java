package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.UserModel;
import com.example.demo.services.UsuarioService;

@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/alumno")
public class AlumnoController {
	private static final String FORMPERSONAL_VIEW="formPersonal";

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@GetMapping(value= {"/formPersonal/{id}"})
	public String formProfesor(@PathVariable(name="id",required=false) Integer id,Model model) {
			model.addAttribute("personal",usuarioService.findUserById(id));
		return FORMPERSONAL_VIEW;
	}
}
