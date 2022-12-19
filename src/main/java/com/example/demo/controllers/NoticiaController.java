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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.NoticiaModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.NoticiaService;
import com.example.demo.services.StrorageService;
import com.example.demo.services.impl.FileSystemStorageService;


@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/news")
public class NoticiaController {

	private static final String NEWS_VIEW="news";
	private static final String FORMNEWS_VIEW="formNews";
	@Autowired
	@Qualifier("noticiaService")
	private NoticiaService noticiaService;
	@Autowired
	@Qualifier("strorageService")
	private StrorageService strorageService;
	
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
			flash.addFlashAttribute("success","Article successfully deleted");
		else 
			flash.addFlashAttribute("error","Article unsuccessfully deleted");
		return "redirect:/news/listNews";
	}
	@PostMapping("/addNews")
	public String addNews(@ModelAttribute("article") NoticiaModel newsModel,RedirectAttributes flash,BindingResult result,@RequestParam("file") MultipartFile img) {
		if (result.hasErrors()) {
			 return FORMNEWS_VIEW;
		 }else {
				 if(newsModel.getId()==0) {
					 System.err.println("Llego");
					 	strorageService.almacenarArchivo(img);
					 	newsModel.setImagen(img.getOriginalFilename());
						noticiaService.addNoticia(newsModel);
						flash.addFlashAttribute("success","Article successfully inserted");
					}else {
						noticiaService.updateNoticia(newsModel);
						flash.addFlashAttribute("success","Article successfully updated");
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
