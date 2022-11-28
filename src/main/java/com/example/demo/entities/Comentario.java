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
	public Comentario(int idComentario, Alumno idAlumno, Curso idCurso, String comentario) {
		super();
		this.idComentario = idComentario;
		this.alumno = idAlumno;
		this.curso = idCurso;
		this.comentario = comentario;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public Alumno getIdAlumno() {
		return alumno;
	}
	public void setIdAlumno(Alumno idAlumno) {
		this.alumno = idAlumno;
	}
	public Curso getIdCurso() {
		return curso;
	}
	public void setIdCurso(Curso idCurso) {
		this.curso = idCurso;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", idAlumno=" + alumno + ", idCurso=" + curso
				+ ", comentario=" + comentario + "]";
	}
	
}