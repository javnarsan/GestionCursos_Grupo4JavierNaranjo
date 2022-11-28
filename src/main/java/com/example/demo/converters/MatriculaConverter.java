package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Matricula;
import com.example.demo.models.MatriculaModel;


@Component("matriculaConverter")
public class MatriculaConverter {
	public MatriculaModel entity2model(Matricula matricula) {
		MatriculaModel matriculaModel=new MatriculaModel();
		matriculaModel.setId(matricula.getId());
		matriculaModel.setAlumnoMat(matricula.getAlumnoMat());
		matriculaModel.setCursoMat(matricula.getCursoMat());
		matriculaModel.setValoraciones(matricula.getValoraciones());
		return matriculaModel;
	}
	public Matricula model2entity(MatriculaModel matriculaModel) {
		Matricula matricula=new Matricula();
		matricula.setId(matriculaModel.getId());
		matricula.setAlumnoMat(matriculaModel.getAlumnoMat());
		matricula.setCursoMat(matriculaModel.getCursoMat());
		matricula.setValoraciones(matriculaModel.getValoraciones());
		return matricula;
		
	}

}
