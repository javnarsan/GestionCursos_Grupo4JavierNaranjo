package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Alumno;
import com.example.demo.models.AlumnoModel;

public interface AlumnoService {
	public abstract List<Alumno> listAllCourses();
	public abstract Alumno addStudent(Alumno alumno);
	public abstract int removeStudent(int id);
	public abstract Alumno updateStudent(Alumno alumno);
	public abstract Alumno transform(AlumnoModel alumnoModel);
	public abstract AlumnoModel transform(Alumno alumno);
	public abstract AlumnoModel finAlumno(int id);

}
