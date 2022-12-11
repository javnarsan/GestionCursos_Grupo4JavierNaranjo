package com.example.demo.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	public CursoModel(int id, String nombre, String descripcion, int nivel, User usuario,
			Date fechaInicio, Date fechaFin, List<Comentario> comentarios, List<Matricula> matriculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.profesor = usuario;
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
	public User getUsuario() {
		return profesor;
	}
	public void setUsuario(User usuario) {
		this.profesor = usuario;
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
	
	
	
}