package com.example.demo.models;

public class CursoModel {
	private int idAdministrador;
	private String nombre;
	private String descripcion;
	private int nivel;
	private int idProfesor;
	private String fechaInicio;
	private String fechaFin;
	public CursoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CursoModel(int idAdministrador, String nombre, String descripcion, int nivel, int idProfesor, String fechaInicio,
			String fechaFin) {
		super();
		this.idAdministrador = idAdministrador;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.idProfesor = idProfesor;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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
	public int getIdProfesor() {
		return idProfesor;
	}
	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
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
	@Override
	public String toString() {
		return "CursoModel [idAdministrador=" + idAdministrador + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", nivel=" + nivel + ", idProfesor=" + idProfesor + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + "]";
	}
	
	
}