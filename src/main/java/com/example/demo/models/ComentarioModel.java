package com.example.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entities.Alumno;
import com.example.demo.entities.Curso;

public class ComentarioModel {
	private int idComentario;
	private Alumno alumno;
	private Curso curso;
	private String comentario;
	public ComentarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComentarioModel(int idComentario, Alumno alumno, Curso curso, String comentario) {
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
		return "ComentarioModel [idComentario=" + idComentario + ", alumno=" + alumno + ", curso=" + curso
				+ ", comentario=" + comentario + "]";
	}
	
	
}