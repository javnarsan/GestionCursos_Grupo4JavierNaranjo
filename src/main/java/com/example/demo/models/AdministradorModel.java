package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.entities.Noticia;

public class AdministradorModel {
	private int idAdministrador;
	private String usuario;	
	private String password;
	private String rol;
	private List<Noticia> noticias;
	public AdministradorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdministradorModel(int idAdministrador, String usuario, String password, String rol,
			List<Noticia> noticias) {
		super();
		this.idAdministrador = idAdministrador;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	@Override
	public String toString() {
		return "AdministradorModel [idAdministrador=" + idAdministrador + ", usuario=" + usuario + ", password="
				+ password + ", rol=" + rol + ", noticias=" + noticias + "]";
	}
	
	
	
}