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
	private User alumnoMat;
	@ManyToOne
	@JoinColumn(name="cursoMatId")
	private Curso cursoMat;
	private int valoraciones;
	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matricula(int id, User alumnoMat, Curso cursoMat, int valoraciones) {
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
		return "Matricula [id=" + id + ", alumnoMat=" + alumnoMat + ", cursoMat=" + cursoMat + ", valoraciones="
				+ valoraciones + "]";
	}
	
}
