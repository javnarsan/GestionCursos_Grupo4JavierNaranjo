package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Matricula;
import com.example.demo.models.MatriculaModel;


@Component("matriculaConverter")
public class MatriculaConverter {
	public MatriculaModel entity2model(Matricula matricula) {
		MatriculaModel matriculaModel=new MatriculaModel();
		matriculaModel.setId(matricula.getId());
		//matriculaModel.setDdAlumno(matricula.getDdAlumno());
		//matriculaModel.setIdCurso(matricula.getIdCurso());
		matriculaModel.setValoraciones(matricula.getValoraciones());
		return matriculaModel;
	}
	public Matricula model2entity(MatriculaModel matriculaModel) {
		Matricula matricula=new Matricula();
		matricula.setId(matriculaModel.getId());
		//matricula.setDdAlumno(matriculaModel.getDdAlumno());
		//matricula.setIdCurso(matriculaModel.getIdCurso());
		matricula.setValoraciones(matriculaModel.getValoraciones());
		return matricula;
		
	}

}
