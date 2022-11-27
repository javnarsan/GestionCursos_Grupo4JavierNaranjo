package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Comentario;
import com.example.demo.models.ComentarioModel;


@Component("comentarioConverter")
public class ComentarioConverter {
	public ComentarioModel entity2model(Comentario comentario) {
		ComentarioModel comentarioModel=new ComentarioModel();
		comentarioModel.setIdAlumno(comentario.getIdAlumno());
		comentarioModel.setIdComentario(comentario.getIdComentario());
		comentarioModel.setIdCurso(comentario.getIdCurso());
		comentarioModel.setComentario(comentario.getComentario());
		return comentarioModel;
	}
	public Comentario model2entity(ComentarioModel comentarioModel) {
		Comentario comentario=new Comentario();
		comentario.setIdAlumno(comentarioModel.getIdAlumno());
		comentario.setIdComentario(comentarioModel.getIdComentario());
		comentario.setIdCurso(comentarioModel.getIdCurso());
		comentario.setComentario(comentarioModel.getComentario());
		return comentario;
		//comentario
	}

}

