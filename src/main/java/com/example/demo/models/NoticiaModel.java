package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.Date;

import com.example.demo.entities.User;

public class NoticiaModel {
	private int id;
	private String titulo;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private String imagen;
	public NoticiaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticiaModel(int id, String titulo, String descripcion, LocalDateTime fechaCreacion, String imagen) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.imagen = imagen;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public String toString() {
		return "NoticiaModel [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fechaCreacion="
				+ fechaCreacion + ", imagen=" + imagen + "]";
	}
}
