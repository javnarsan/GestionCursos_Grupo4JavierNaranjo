package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.services.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	private static final String CURSOS_VIEW="cursos";
	@Autowired
	@Qualifier("cursoService")
	private CursoService cursoService;
	
	@GetMapping("/listCursos")
	public ModelAndView listCursos() {
		ModelAndView mav=new ModelAndView(CURSOS_VIEW);
		mav.addObject(CURSOS_VIEW,cursoService.listAllCursos());
		return mav;
	}
	
}
