package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Alumno;
import com.example.demo.models.AlumnoModel;



@Component("alumnoConverter")
public class AlumnoConverter {
	public AlumnoModel entity2model(Alumno alumno) {
		AlumnoModel alumnoModel=new AlumnoModel();
		alumnoModel.setIdAlumno(alumno.getIdAlumno());
		alumnoModel.setNombre(alumno.getNombre());
		alumnoModel.setApellidos(alumno.getApellidos());
		alumnoModel.setEmail(alumno.getEmail());
		alumnoModel.setUsuario(alumno.getUsuario());
		alumnoModel.setPassword(alumno.getPassword());
		alumnoModel.setFoto(alumno.getFoto());
		alumnoModel.setComentarios(alumno.getComentarios());
		alumnoModel.setMatriculas(alumno.getMatriculas());
		return alumnoModel;
	}
	public Alumno model2entity(AlumnoModel alumnoModel) {
		Alumno alumno=new Alumno();
		alumno.setIdAlumno(alumnoModel.getIdAlumno());
		alumno.setNombre(alumnoModel.getNombre());
		alumno.setApellidos(alumnoModel.getApellidos());
		alumno.setEmail(alumnoModel.getEmail());
		alumno.setUsuario(alumnoModel.getUsuario());
		alumno.setPassword(alumnoModel.getPassword());
		alumno.setFoto(alumnoModel.getFoto());
		alumno.setMatriculas(alumnoModel.getMatriculas());
		alumno.setComentarios(alumnoModel.getComentarios());
		return alumno;
		
	}

}
