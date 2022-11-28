package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Noticia;
import com.example.demo.models.NoticiaModel;

@Component("noticiaConverter")
public class NoticiaConverter {
	public NoticiaModel entity2model(Noticia noticia) {
		NoticiaModel noticiaModel=new NoticiaModel();
		noticiaModel.setId(noticia.getId());
		noticiaModel.setTitulo(noticia.getTitulo());
		noticiaModel.setDescripcion(noticia.getDescripcion());
		noticiaModel.setImagen(noticia.getImagen());
		noticiaModel.setAdministrador(noticia.getAdministrador());
		return noticiaModel;
	}
	public Noticia model2entity(NoticiaModel noticiaModel) {
		Noticia noticia=new Noticia();
		noticia.setId(noticiaModel.getId());
		noticia.setTitulo(noticiaModel.getTitulo());
		noticia.setDescripcion(noticiaModel.getDescripcion());
		noticia.setImagen(noticiaModel.getImagen());
		noticia.setAdministrador(noticiaModel.getAdministrador());
		return noticia;
		
	}

}