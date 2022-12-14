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

import com.example.demo.models.NoticiaModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.NoticiaService;


@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/news")
public class NoticiaController {

	private static final String NEWS_VIEW="news";
	private static final String FORMNEWS_VIEW="formNews";
	@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;
	
	@GetMapping("/listNews")
	public ModelAndView listNews() {
		ModelAndView mav=new ModelAndView(NEWS_VIEW);
		mav.addObject("titulo", "Control Noticias");
		mav.addObject("articles",noticiaService.listAllNoticias());
		return mav;
	}
	@GetMapping("/deleteNews/{id}")
	public String deletetNews(@PathVariable("id") int id,RedirectAttributes flash) {
		if(noticiaService.removeNoticia(id)==0) 
			flash.addFlashAttribute("success","Article deleted correctly");
		else 
			flash.addFlashAttribute("error","Article deleted incorrectly");
		return "redirect:/news/listNews";
	}
	@PostMapping("/addNews")
	public String addNews(@ModelAttribute("article") NoticiaModel newsModel,RedirectAttributes flash,BindingResult result) {
		if (result.hasErrors()) {
			 return FORMNEWS_VIEW;
		 }else {
				 if(newsModel.getId()==0) {
					 
						noticiaService.addNoticia(newsModel);
						flash.addFlashAttribute("success","Article inserted successfully");
					}else {
						noticiaService.updateNoticia(newsModel);
						flash.addFlashAttribute("success","Article inserted unsuccessfully");
					}
					return "redirect:/news/listNews"; 
			}
		 }
		
	@GetMapping(value= {"/formNews/","/formNews/{id}"})
	public String formNewr(@PathVariable(name="id",required=false) Integer id,Model model) {
		if(id==null) 
			model.addAttribute("article",new NoticiaModel());
		else 
			model.addAttribute("article",noticiaService.findNoticia(id));
		return FORMNEWS_VIEW;
	}
}
