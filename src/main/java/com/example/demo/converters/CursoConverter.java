package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Curso;
import com.example.demo.models.CursoModel;



@Component("cursoConverter")
public class CursoConverter {
	public CursoModel entity2model(Curso curso) {
		CursoModel cursoModel=new CursoModel();
		cursoModel.setIdAdministrador(curso.getIdAdministrador());
		cursoModel.setNombre(curso.getNombre());
		cursoModel.setDescripcion(curso.getDescripcion());
		//cursoModel.setIdProfesor(curso.getIdProfesor());
		cursoModel.setFechaInicio(curso.getFechaInicio());
		cursoModel.setFechaFin(curso.getFechaFin());
		cursoModel.setNivel(curso.getNivel());
		return cursoModel;
	}
	public Curso model2entity(CursoModel cursoModel) {
		Curso curso=new Curso();
		curso.setIdAdministrador(cursoModel.getIdAdministrador());
		curso.setNombre(cursoModel.getNombre());
		curso.setDescripcion(cursoModel.getDescripcion());
		//curso.setIdProfesor(cursoModel.getIdProfesor());
		curso.setFechaInicio(cursoModel.getFechaInicio());
		curso.setFechaFin(cursoModel.getFechaFin());
		curso.setNivel(cursoModel.getNivel());
		return curso;
	}

}
