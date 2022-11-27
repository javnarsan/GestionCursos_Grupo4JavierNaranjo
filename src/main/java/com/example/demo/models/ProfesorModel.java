package com.example.demo.models;

public class ProfesorModel {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String usuario;
	private String password;
	public ProfesorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProfesorModel(int id, String nombre, String apellido, String email, String usuario, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
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
	@Override
	public String toString() {
		return "ProfesorModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", usuario=" + usuario + ", password=" + password + "]";
	}
	
}
