package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Curso;
import com.example.demo.entities.Matricula;
import com.example.demo.models.CursoModel;
import com.example.demo.models.MatriculaModel;

public interface MatriculaService {
	public abstract List<MatriculaModel> listAllMatriculas();
	public abstract Matricula addMatricula(MatriculaModel matriculaModel);
	public abstract int removeMatricula(int id);
	public abstract Matricula updateMatricula(MatriculaModel matriculaModel);
	public abstract Matricula transform(MatriculaModel matriculaModel);
	public abstract MatriculaModel transform(Matricula matricula);
	public abstract MatriculaModel findMatricula(int id);
}
