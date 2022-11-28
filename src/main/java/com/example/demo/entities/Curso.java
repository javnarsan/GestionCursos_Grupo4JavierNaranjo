package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	private String nombre;
	private String descripcion;
	private int nivel;
	@ManyToOne
	@JoinColumn(name="profesorId")
	private Profesor profesor;
	private String fechaInicio;
	private String fechaFin;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "curso")
	private List<Comentario> comentarios;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "cursoMat")
	private List<Matricula> matriculas;
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Curso(int idAdministrador, String nombre, String descripcion, int nivel, Profesor profesor,
			String fechaInicio, String fechaFin, List<Comentario> comentarios, List<Matricula> matriculas) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.profesor = profesor;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.comentarios = comentarios;
		this.matriculas = matriculas;
	}
	public int getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
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
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
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
		return "Curso [idAdministrador=" + idAdministrador + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", nivel=" + nivel + ", profesor=" + profesor + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", comentarios=" + comentarios + ", matriculas=" + matriculas + "]";
	}
	
	
}