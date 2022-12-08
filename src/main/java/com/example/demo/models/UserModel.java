package com.example.demo.models;

public class UserModel {
	private long id;
	
	private String email;
	private String password;
	private boolean enabled;
	private String role;
	private String nombre;
	private String apellidos;
	private String foto;
	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserModel(long id, String email, String password, boolean enabled, String role, String nombre,
			String apellidos, String foto) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.foto = foto;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", password=" + password + ", enabled=" + enabled
				+ ", role=" + role + ", nombre=" + nombre + ", apellidos=" + apellidos + ", foto=" + foto + "]";
	}
	
	
}
