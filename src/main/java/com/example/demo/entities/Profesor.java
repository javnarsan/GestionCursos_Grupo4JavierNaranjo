package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.GetMapping;

@Entity
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String usuario;
	private String password;
	private String rol;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "profesor")
	private List<Curso> cursosProf;
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profesor(int id, String nombre, String apellido, String email, String usuario, String password, String rol,
			List<Curso> cursosProf) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.cursosProf = cursosProf;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<Curso> getCursosProf() {
		return cursosProf;
	}

	public void setCursosProf(List<Curso> cursosProf) {
		this.cursosProf = cursosProf;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", usuario=" + usuario + ", password=" + password + ", rol=" + rol + ", cursosProf=" + cursosProf
				+ "]";
	}


	
}
