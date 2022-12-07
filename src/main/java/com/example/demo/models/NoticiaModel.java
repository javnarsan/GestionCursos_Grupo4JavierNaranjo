package com.example.demo.models;

import com.example.demo.entities.User;

public class NoticiaModel {
	private int id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private User usuario;
	
	public NoticiaModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoticiaModel(int id, String titulo, String descripcion, String imagen, User administrador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.usuario = administrador;
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "NoticiaModel [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", usuario=" + usuario + "]";
	}

	
}
