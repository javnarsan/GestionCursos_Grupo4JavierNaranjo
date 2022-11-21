package com.example.demo.entity;

public class Matricula {
	private int id;
	private int ddAlumno;
	private int idCurso;
	private int valoraciones;
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
		return "Matricula [id=" + id + ", ddAlumno=" + ddAlumno + ", idCurso=" + idCurso + ", valoraciones="
				+ valoraciones + "]";
	}
	
}
