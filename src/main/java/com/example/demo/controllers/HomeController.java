package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Noticia;
import com.example.demo.repositories.NoticiaRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private NoticiaRepository noticiaRepositorio;
	
	@GetMapping("/")
	public ModelAndView verPaginaDeInicio() {
		List<Noticia> ultimasNoticias = noticiaRepositorio.findAll(PageRequest.of(0,4,Sort.by("fechaCreacion").descending())).toList();
		return new ModelAndView("index")
				      .addObject("ultimasNoticias", ultimasNoticias);
	}
	
	@GetMapping("/noticias")
	public ModelAndView listNews(@PageableDefault(sort = "fechaCreacion",direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Noticia> noticias = noticiaRepositorio.findAll(pageable);
		return new ModelAndView("noticias")
				        .addObject("noticias",noticias);
	}
	
	@GetMapping("/noticia/{id}")
	public ModelAndView mostrarDetallesDeNoticia(@PathVariable Integer id) {
		Noticia noticia = noticiaRepositorio.getOne(id);
		return new ModelAndView("noticia").addObject("noticia",noticia);
	}
}
