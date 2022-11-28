package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComentario;
	@ManyToOne
	@JoinColumn(name="alumnoId")
	private Alumno alumno;
	@ManyToOne
	@JoinColumn(name="cursoId")
	private Curso curso;
	private String comentario;
	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comentario(int idComentario, Alumno alumno, Curso curso, String comentario) {
		super();
		this.idComentario = idComentario;
		this.alumno = alumno;
		this.curso = curso;
		this.comentario = comentario;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", alumno=" + alumno + ", curso=" + curso + ", comentario="
				+ comentario + "]";
	}
	
}