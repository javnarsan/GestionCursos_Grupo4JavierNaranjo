package com.example.demo.controllers;
import java.util.ArrayList;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.models.MatriculaModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.CursoService;
import com.example.demo.services.MatriculaService;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.impl.UserService;

import antlr.collections.List;

@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/alumno")
public class AlumnoController {
	private static final String FORMPERSONAL_VIEW = "formPersonalAlumno";
	private static final String CURSOS = "cursosAlumno";

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("matriculaService")
	private MatriculaService matriculaService;
	
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@GetMapping(value = { "/formPersonal" })
	  public String formAlumno(Model model) {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userEmail = authentication.getName();
	    model.addAttribute("personal", usuarioService.findUserByEmail(userEmail));
	    return FORMPERSONAL_VIEW;
	  }
	@GetMapping(value = { "/cursos" })
	public ModelAndView listCursos() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		ArrayList <MatriculaModel> userMatriculas=(ArrayList<MatriculaModel>) matriculaService.findMatriculaByUser(usuarioService.findUserByEmail(userEmail).getId());
		ArrayList idCursos =new ArrayList<>();
		for(int i=0;i<userMatriculas.size();i++) {
			idCursos.add(userMatriculas.get(i).getCursoMat().getId());
		}
		ModelAndView mav=new ModelAndView(CURSOS);
		mav.addObject("titulo", "Cursos disponibles");
		mav.addObject("cursos",cursoService.listAllCursos());
		mav.addObject("matriculas",idCursos);
		return mav;
	}

	@PreAuthorize("#personalModel.email==authentication.name")
	@PostMapping("/addPersonal")
	public String addPersonal(@Valid @ModelAttribute("personal")UserModel personalModel,BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			return FORMPERSONAL_VIEW;
		} else {
			usuarioService.updateAlumno(personalModel);
			flash.addFlashAttribute("success", "Perfil modificado exitosamente");
		}
		return "redirect:/";

	}
	@PostMapping("/addMatricula/{id}")
	public String addMatricula(@Valid @ModelAttribute("curso") MatriculaModel matriculaModel,@PathVariable("id") int id,RedirectAttributes flash) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		matriculaModel.setAlumnoMat(usuarioService.findUserByEmail(userEmail));
		matriculaModel.setCursoMat(cursoService.findCurso(id));
		matriculaService.addMatricula(matriculaModel);
		return "redirect:/alumno/cursos";
	}

}
