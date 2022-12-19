package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Noticia;
import com.example.demo.models.NoticiaModel;

public interface NoticiaService {
	public abstract List<NoticiaModel> listAllNoticias();
	public abstract Noticia addNoticia(NoticiaModel noticiaModel);
	public abstract int removeNoticia(int id);
	public abstract Noticia updateNoticia(NoticiaModel noticiaModel);
	public abstract Noticia transform(NoticiaModel noticiaModel);
	public abstract NoticiaModel transform(Noticia noticia);
	public abstract NoticiaModel findNoticia(int id);
	
	
}
