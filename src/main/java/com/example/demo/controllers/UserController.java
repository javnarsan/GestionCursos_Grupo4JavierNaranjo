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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.models.UserModel;
import com.example.demo.services.UsuarioService;


@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
public class UserController {
	private static final String Profesores_VIEW="profesores";

	private static final String STUDENTS_VIEW="estudiantes";

	private static final String FORMPROF_VIEW="formProfesor";

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@GetMapping("/listProfesores")
	public ModelAndView listCourses() {
		ModelAndView mav=new ModelAndView(Profesores_VIEW);
		mav.addObject("titulo", "Control Profesores");
		mav.addObject("profesores",usuarioService.listAllProfesores());
		return mav;
	}
	@GetMapping("/deleteProfesor/{id}")
	public String deletetProfesor(@PathVariable("id") int id,RedirectAttributes flash) {
		if(usuarioService.removeProfesor(id)==0) 
			flash.addFlashAttribute("success","Profesor eliminado correctamente");
		else 
			flash.addFlashAttribute("error","No se ha podido eliminar al profesor");
		return "redirect:/admin/listProfesores";
	}
	@PostMapping("/addProfesor")
	public String addProfesor(@ModelAttribute("profesor") UserModel profesorModel,RedirectAttributes flash,BindingResult result) {
		if (result.hasErrors()) {
			 return FORMPROF_VIEW;
		 }else {
			 try {
				 if(profesorModel.getId()==0) {
					 
						usuarioService.addProfesor(profesorModel);
						flash.addFlashAttribute("success","Profesor insertado correctamente");
					}else {
						usuarioService.updateProfesor(profesorModel);
						flash.addFlashAttribute("success","Profesor modificado correctamente");
					}
					return "redirect:/admin/listProfesores"; 
			 }catch(Exception e) {
				 flash.addFlashAttribute("success","Email duplicado");
				 return FORMPROF_VIEW;
			 }
			
			}
		 }
		
	@GetMapping(value= {"/formProfesor/","/formProfesor/{id}"})
	public String formProfesor(@PathVariable(name="id",required=false) Integer id,Model model) {
		if(id==null) 
			model.addAttribute("profesor",new UserModel());
		else 
			model.addAttribute("profesor",usuarioService.findProfesor(id));
		return FORMPROF_VIEW;
	}
	
	@GetMapping("/listarEstudiantes")
	public ModelAndView listStudents() {
		ModelAndView mav = new ModelAndView(STUDENTS_VIEW);
		mav.addObject("titulo", "Control Estudiantes");
		mav.addObject("student",usuarioService.listAllStudents());
		return mav;
	}
	
	@PostMapping("/activarEstudiante/{id}")
	public String activeUser(Model model, @PathVariable(name="id")long id) {
		com.example.demo.entities.User usuario = usuarioService.findUserById(id);
		model.addAttribute("usuario",usuarioService.activarEstudiante(usuarioService.transform(usuario)));
		return "redirect:/admin/listarEstudiantes";
	}
	
	@PostMapping("/desactivarEstudiante/{id}")
	public String deactiveUser(Model model, @PathVariable(name="id")long id) {
		com.example.demo.entities.User usuario = usuarioService.findUserById(id);
		model.addAttribute("usuario",usuarioService.desactivarEstudiante(usuarioService.transform(usuario)));
		return "redirect:/admin/listarEstudiantes";
	}
	
	@GetMapping("/borrarEstudiante/{id}")
	public String borrarEstudiante(Model model, @PathVariable(name="id")int id) {
		usuarioService.borrarEstudiante(id);
		return "redirect:/admin/listarEstudiantes";		
	}
 	
}
