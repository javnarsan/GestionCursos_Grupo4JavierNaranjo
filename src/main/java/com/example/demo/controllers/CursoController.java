package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.CursoModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.CursoService;
import com.example.demo.services.UsuarioService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/cursos")
public class CursoController {
	private static final String CURSOS_VIEW="cursosAdmin";
	private static final String FORMCURSO_VIEW="formCursoAdmin";
	//
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	
	@GetMapping("/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav=new ModelAndView(CURSOS_VIEW);
		mav.addObject("titulo", "Control Cursos");
		mav.addObject("cursos",cursoService.listAllCursos());
		return mav;
	}
	
	@GetMapping(value= {"/formCurso/","/formCurso/{id}"})
	public String formCurso(@PathVariable(name="id",required=false) Integer id,Model model) {
		model.addAttribute("profesores",usuarioService.listAllProfesores());
		if(id==null) 
			model.addAttribute("curso",new CursoModel());
		else 
			model.addAttribute("curso",cursoService.findCurso(id));
		return FORMCURSO_VIEW;
	}
	
	@PostMapping("/addCurso")
	public String addCurso(@ModelAttribute("curso") CursoModel cursoModel,@RequestParam("idProfesor") long idProfesor,RedirectAttributes flash) {
		cursoModel.setProfesor(usuarioService.findUserById(idProfesor));
		if(cursoModel.getId()==0) {
			cursoService.addCurso(cursoModel);
			flash.addFlashAttribute("success","Curso insertado correctamente");
		}else {
			cursoService.updateCurso(cursoModel);
			flash.addFlashAttribute("success","Curso modificado correctamente");
		}
		return "redirect:/cursos/listCursos";
	}
	
	@GetMapping("/deleteCurso/{id}")
	public String deleteCurso(@PathVariable("id") int id, RedirectAttributes flash) {
		if(cursoService.removeCurso(id)==0)
			flash.addFlashAttribute("success","Curso eliminado correctamente");
		else
			flash.addFlashAttribute("error","No se ha podido eliminar el curso");
		return "redirect:/cursos/listCursos";
				
	}
	
}
