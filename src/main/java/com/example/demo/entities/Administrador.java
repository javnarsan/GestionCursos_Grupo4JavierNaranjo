package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administrador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	private String usuario;	
	private String password;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "administrador")
	private List<Noticia> noticias;
	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrador(int idAdministrador, String usuario, String password, List<Noticia> noticias) {
		super();
		this.idAdministrador = idAdministrador;
		this.usuario = usuario;
		this.password = password;
		this.noticias = noticias;
	}
	public int getIdAdministrador() {
		return idAdministrador;
	}
	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	@Override
	public String toString() {
		return "Administrador [idAdministrador=" + idAdministrador + ", usuario=" + usuario + ", password=" + password
				+ ", noticias=" + noticias + "]";
	}
	
}