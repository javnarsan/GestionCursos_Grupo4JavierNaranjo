package com.example.demo.models;


import java.sql.Date;
import java.util.List;

import com.example.demo.entities.Comentario;
import com.example.demo.entities.Matricula;
import com.example.demo.entities.User;

public class CursoModel {
	private int id;
	private String nombre;
	private String descripcion;
	private int nivel;
	private User profesor;
	private Date fechaInicio;
	private Date fechaFin;
	private List<Comentario> comentarios;
	private List<Matricula> matriculas;
	public CursoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoModel(int id, String nombre, String descripcion, int nivel, User profesor,
			Date fechaInicio, Date fechaFin, List<Comentario> comentarios, List<Matricula> matriculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.profesor = profesor;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.comentarios = comentarios;
		this.matriculas = matriculas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public User getProfesor() {
		return profesor;
	}
	public void setProfesor(User profesor) {
		this.profesor = profesor;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public List<Matricula> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	@Override
	public String toString() {
		return "CursoModel [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", nivel=" + nivel
				+ ", profesor=" + profesor + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
	
}