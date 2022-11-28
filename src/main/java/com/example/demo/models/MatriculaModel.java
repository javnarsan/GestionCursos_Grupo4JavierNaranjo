package com.example.demo.models;

import com.example.demo.entities.Alumno;
import com.example.demo.entities.Curso;


public class MatriculaModel {
	private int id;
	private Alumno alumnoMat;
	private Curso cursoMat;
	private int valoraciones;
	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatriculaModel(int id, Alumno alumnoMat, Curso cursoMat, int valoraciones) {
		super();
		this.id = id;
		this.alumnoMat = alumnoMat;
		this.cursoMat = cursoMat;
		this.valoraciones = valoraciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Alumno getAlumnoMat() {
		return alumnoMat;
	}
	public void setAlumnoMat(Alumno alumnoMat) {
		this.alumnoMat = alumnoMat;
	}
	public Curso getCursoMat() {
		return cursoMat;
	}
	public void setCursoMat(Curso cursoMat) {
		this.cursoMat = cursoMat;
	}
	public int getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(int valoraciones) {
		this.valoraciones = valoraciones;
	}
	@Override
	public String toString() {
		return "MatriculaModel [id=" + id + ", alumnoMat=" + alumnoMat + ", cursoMat=" + cursoMat + ", valoraciones="
				+ valoraciones + "]";
	}
	
}
