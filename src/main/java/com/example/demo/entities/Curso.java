package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String descripcion;
	private int nivel;
	@ManyToOne
	@JoinColumn(name="profesorId")
	private User profesorCurs;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaInicio;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date fechaFin;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "curso")
	private List<Comentario> comentarios;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "cursoMat")
	private List<Matricula> matriculas;
	public Curso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Curso(int id, String nombre, String descripcion, int nivel, User profesor,
			Date fechaInicio, Date fechaFin, List<Comentario> comentarios, List<Matricula> matriculas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.profesorCurs = profesor;
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
		return profesorCurs;
	}
	public void setProfesor(User profesor) {
		this.profesorCurs = profesor;
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
		return "Curso [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", nivel=" + nivel + ", profesor=" + profesorCurs + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", comentarios=" + comentarios + ", matriculas=" + matriculas + "]";
	}
	
	
}