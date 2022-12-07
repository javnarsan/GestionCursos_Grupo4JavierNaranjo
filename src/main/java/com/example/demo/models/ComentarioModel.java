package com.example.demo.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.entities.Curso;
import com.example.demo.entities.User;

public class ComentarioModel {
	private int idComentario;
	private User usuario;
	private Curso curso;
	private String comentario;
	public ComentarioModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComentarioModel(int idComentario, User usuario, Curso curso, String comentario) {
		super();
		this.idComentario = idComentario;
		this.usuario = usuario;
		this.curso = curso;
		this.comentario = comentario;
	}
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	public User getUsuario() {
		return usuario;
	}
	public void setUsuario(User usuario) {
		this.usuario = usuario;
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
		return "ComentarioModel [idComentario=" + idComentario + ", usuario=" + usuario + ", curso=" + curso
				+ ", comentario=" + comentario + "]";
	}
	
	
}