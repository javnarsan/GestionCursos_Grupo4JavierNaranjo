package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class MatriculaModel {
	private int id;
	private int ddAlumno;
	private int idCurso;
	private int valoraciones;
	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MatriculaModel(int id, int ddAlumno, int idCurso, int valoraciones) {
		super();
		this.id = id;
		this.ddAlumno = ddAlumno;
		this.idCurso = idCurso;
		this.valoraciones = valoraciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDdAlumno() {
		return ddAlumno;
	}
	public void setDdAlumno(int ddAlumno) {
		this.ddAlumno = ddAlumno;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(int valoraciones) {
		this.valoraciones = valoraciones;
	}
	@Override
	public String toString() {
		return "MatriculaModel [id=" + id + ", ddAlumno=" + ddAlumno + ", idCurso=" + idCurso + ", valoraciones="
				+ valoraciones + "]";
	}
	
}
