package com.example.demo.models;

import com.example.demo.entities.Curso;
import com.example.demo.entities.User;


public class MatriculaModel {
	private int id;
	private User usuarioMat;
	private Curso cursoMat;
	private int valoraciones;
	public MatriculaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MatriculaModel(int id, User ausuarioMat, Curso cursoMat, int valoraciones) {
		super();
		this.id = id;
		this.usuarioMat = usuarioMat;
		this.cursoMat = cursoMat;
		this.valoraciones = valoraciones;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUsuarioMat() {
		return usuarioMat;
	}
	public void setUsuarioMat(User usuarioMat) {
		this.usuarioMat = usuarioMat;
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
		return "MatriculaModel [id=" + id + ", usuarioMat=" + usuarioMat + ", cursoMat=" + cursoMat + ", valoraciones="
				+ valoraciones + "]";
	}
	
}
