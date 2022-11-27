package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Noticia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String descripcion;
	private String imagen;
	private int IdAdministrador;
	
	public Noticia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Noticia(int id, String titulo, String descripcion, String imagen, int idAdministrador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagen = imagen;
		IdAdministrador = idAdministrador;
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
	public int getIdAdministrador() {
		return IdAdministrador;
	}
	public void setIdAdministrador(int idAdministrador) {
		IdAdministrador = idAdministrador;
	}
	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", IdAdministrador=" + IdAdministrador + "]";
	}
	
}
