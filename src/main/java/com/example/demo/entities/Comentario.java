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
	private int idCurso;
	private String comentario;
	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comentario(int idComentario, Alumno idAlumno, int idCurso, String comentario) {
		super();
		this.idComentario = idComentario;
		this.alumno = idAlumno;
		this.idCurso = idCurso;
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
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", idAlumno=" + alumno + ", idCurso=" + idCurso
				+ ", comentario=" + comentario + "]";
	}
	
}