package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Alumno;
import com.example.demo.models.AlumnoModel;

public interface AlumnoService {
	public abstract List<AlumnoModel> listAllAlumnos();
	public abstract Alumno addAlumno(AlumnoModel alumnoModel);
	public abstract int removeAlumnot(int id);
	public abstract Alumno updateAlumno(AlumnoModel alumnoModel);
	public abstract Alumno transform(AlumnoModel alumnoModel);
	public abstract AlumnoModel transform(Alumno alumno);
	public abstract AlumnoModel finAlumno(int id);

}
