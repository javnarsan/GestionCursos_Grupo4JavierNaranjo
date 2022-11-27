package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Profesor;
import com.example.demo.models.ProfesorModel;



@Component("profesorConverter")
public class ProfesorConverter {
	public ProfesorModel entity2model(Profesor profesor) {
		ProfesorModel profesorModel=new ProfesorModel();
		profesorModel.setId(profesor.getId());
		profesorModel.setNombre(profesor.getNombre());
		profesorModel.setApellido(profesor.getApellido());
		profesorModel.setEmail(profesor.getEmail());
		profesorModel.setPassword(profesor.getPassword());
		profesorModel.setUsuario(profesor.getUsuario());
		return profesorModel;
	}
	public Profesor model2entity(ProfesorModel profesorModel) {
		Profesor profesor=new Profesor();
		profesor.setId(profesorModel.getId());
		profesor.setNombre(profesorModel.getNombre());
		profesor.setApellido(profesorModel.getApellido());
		profesor.setEmail(profesorModel.getEmail());
		profesor.setPassword(profesorModel.getPassword());
		profesor.setUsuario(profesorModel.getUsuario());
		return profesor;
		
	}

}