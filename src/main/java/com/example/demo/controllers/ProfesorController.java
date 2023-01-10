package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.services.CursoService;
import com.example.demo.services.UsuarioService;

@Controller
@PreAuthorize("hasRole('ROLE_PROFESOR')")
@RequestMapping("/profesor")
public class ProfesorController {
	private static final String FORMPERSONAL_VIEW = "formPersonalProfesor";
	private static final String CURSOSPROF_VIEW = "cursosProfesor";
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	
	@GetMapping(value = { "/formPersonalProfesor" })
	  public String formProfesor(Model model) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    model.addAttribute("personal", usuarioService.findUserByEmail(userEmail));
	    return FORMPERSONAL_VIEW;
	  }
	@GetMapping(value = { "/cursos" })
	  public String listCursos(Model model) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    long idProfesor = usuarioService.findUserByEmail(userEmail).getId();
	    model.addAttribute("idProf", idProfesor);
	    var listaFiltrada = cursoService.listAllCursos()
	    		.stream().filter(x->x.getProfesor().getId()==idProfesor).toList();
	    model.addAttribute("cursos", listaFiltrada);
	    return CURSOSPROF_VIEW;
	  }
	@PreAuthorize("#personalModel.email==authentication.name")
	@PostMapping("/addPersonal")
	public String addPersonal(@Valid @ModelAttribute("user") User user, @ModelAttribute("personal") UserModel personalModel, RedirectAttributes flash,
			BindingResult result) {
		System.out.println(result);
		if (result.hasErrors()) {
			return FORMPERSONAL_VIEW;
		} else {
			usuarioService.updateProfesor(personalModel);
			flash.addFlashAttribute("success", "Perfil modificado exitosamente");
		}
		return "redirect:/";

	}
}
