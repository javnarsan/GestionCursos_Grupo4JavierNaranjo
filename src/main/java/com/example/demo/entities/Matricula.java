package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="alumnoMatId")
	private Alumno alumnoMat;
	@ManyToOne
	@JoinColumn(name="cursoMatId")
	private Curso cursoMat;
	private int valoraciones;
	
	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Matricula(int id, Alumno ddAlumno, Curso idCurso, int valoraciones) {
		super();
		this.id = id;
		this.alumnoMat = ddAlumno;
		this.cursoMat = idCurso;
		this.valoraciones = valoraciones;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Alumno getDdAlumno() {
		return alumnoMat;
	}
	public void setDdAlumno(Alumno ddAlumno) {
		this.alumnoMat = ddAlumno;
	}
	public Curso getIdCurso() {
		return cursoMat;
	}
	public void setIdCurso(Curso idCurso) {
		this.cursoMat = idCurso;
	}
	public int getValoraciones() {
		return valoraciones;
	}
	public void setValoraciones(int valoraciones) {
		this.valoraciones = valoraciones;
	}
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", ddAlumno=" + alumnoMat + ", idCurso=" + cursoMat + ", valoraciones="
				+ valoraciones + "]";
	}
	
}
