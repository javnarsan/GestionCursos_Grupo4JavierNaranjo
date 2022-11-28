package com.example.demo.models;

public class ComentarioModel {
	private int idComentario;
	private int idAlumno;
	private int idCurso;
	private String comentario;
	public ComentarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComentarioModel(int idComentario, int idAlumno, int idCurso, String comentario) {
		super();
		this.idComentario = idComentario;
		this.idAlumno = idAlumno;
		this.idCurso = idCurso;
		this.comentario = comentario;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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
		return "ComentarioModel [idComentario=" + idComentario + ", idAlumno=" + idAlumno + ", idCurso=" + idCurso
				+ ", comentario=" + comentario + "]";
	}
	
}