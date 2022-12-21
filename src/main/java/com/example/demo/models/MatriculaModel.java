package com.example.demo.models;

import com.example.demo.entities.Curso;
import com.example.demo.entities.User;


public class MatriculaModel {
	private int id;
	private User alumnoMat;
	private Curso cursoMat;
	private int valoraciones;
	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatriculaModel(int id, User alumnoMat, Curso cursoMat, int valoraciones) {
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
	public User getAlumnoMat() {
		return alumnoMat;
	}
	public void setAlumnoMat(User alumnoMat) {
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
