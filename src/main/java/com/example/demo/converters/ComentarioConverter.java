package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Comentario;
import com.example.demo.models.ComentarioModel;


@Component("comentarioConverter")
public class ComentarioConverter {
	public ComentarioModel entity2model(Comentario comentario) {
		ComentarioModel comentarioModel=new ComentarioModel();
		comentarioModel.setAlumno(comentario.getAlumno());
		comentarioModel.setIdComentario(comentario.getIdComentario());
		comentarioModel.setCurso(comentario.getCurso());
		comentarioModel.setComentario(comentario.getComentario());
		return comentarioModel;
	}
	public Comentario model2entity(ComentarioModel comentarioModel) {
		Comentario comentario=new Comentario();
		comentario.setAlumno(comentarioModel.getAlumno());
		comentario.setIdComentario(comentarioModel.getIdComentario());
		comentario.setCurso(comentarioModel.getCurso());
		comentario.setComentario(comentarioModel.getComentario());
		return comentario;
	}

}

