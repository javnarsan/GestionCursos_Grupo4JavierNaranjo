package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Curso;
import com.example.demo.models.CursoModel;


public interface CursoService {
	public abstract List<CursoModel> listAllCursos();
	public abstract Curso addCurso(CursoModel cursoModel);
	public abstract int removeCurso(int id);
	public abstract Curso updateCurso(CursoModel cursoModel);
	public abstract Curso transform(CursoModel cursoModel);
	public abstract CursoModel transform(Curso curso);
	public abstract CursoModel findCurso(int id);

}
