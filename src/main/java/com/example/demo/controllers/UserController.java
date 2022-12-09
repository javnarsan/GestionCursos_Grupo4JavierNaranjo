package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.services.UsuarioService;
import com.example.demo.services.impl.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	private static final String Profesores_VIEW="profesores";
	private static final String FORMPROF_VIEW="formProfesor";
	@Autowired
	@Qualifier("usuarioService")
	private UsuarioService usuarioService;
	
	@GetMapping("/listProfesores")
	public ModelAndView listCourses() {
		ModelAndView mav=new ModelAndView(Profesores_VIEW);
		
		mav.addObject("profesores",usuarioService.listAllProfesores());
		return mav;
	}
	@GetMapping("/deleteProfesor/{id}")
	public String deletetProfesor(@PathVariable("id") int id,RedirectAttributes flash) {
		if(usuarioService.removeProfesor(id)==0) 
			flash.addFlashAttribute("success","Profesor eliminado correctamente");
		else 
			flash.addFlashAttribute("error","No de ha podido eliminar al profesor");
		return "redirect:/users/listProfesores";
	}
	@GetMapping("/addProfesor")
	public String addProfesor(@ModelAttribute("profesor") UserModel profesorModel,RedirectAttributes flash) {
		if(profesorModel.getId()==0) {
			usuarioService.addProfesor(profesorModel);
			flash.addFlashAttribute("success","Profesor insertado correctamente");
		}else {
			usuarioService.updateProfesor(profesorModel);
			flash.addFlashAttribute("success","Profesor modificado correctamente");
		}
		return "redirect:/users/listProfesores";
	}
	@GetMapping(value= {"/formProfesor/","/formProfesor/{id}"})
	public String formProfesor(@PathVariable(name="id",required=false) Integer id,Model model) {
		if(id==null) 
			model.addAttribute("profesor",new UserModel());
		else 
			model.addAttribute("profesor",usuarioService.findProfesor(id));
		return FORMPROF_VIEW;
	}
	

}
