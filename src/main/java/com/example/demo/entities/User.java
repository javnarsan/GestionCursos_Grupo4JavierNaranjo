package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.bytebuddy.implementation.bind.annotation.Empty;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	@NotNull(message="El email es obligatorio")
	@Column(name="email",unique=true,nullable=false)
	private String email;
	
	@Column(name="password",nullable=false)
	@NotNull(message="El password es obligatorio")
	@Size(max=100)
	private String password;
	
	private boolean enabled;
	private String role;
	@NotNull(message="El nombre es obligatorio")
	private String nombre;
	@NotNull(message="El apellido es obligatorio")
	@Size(min=1,max=10)
	@NotEmpty
	private String apellidos;
	private String foto;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "alumnoCom")
	private List<Comentario> comentarios;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "alumnoMat")
	private List<Matricula> matriculas;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "profesorCurs")
	private List<Curso> cursosProf;
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "administradorNot")
	private List<Noticia> noticias;
	public User() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	public User(long id, String email, String password, boolean enabled, String role, String nombre, String apellidos,
			String foto, List<Comentario> comentarios, List<Matricula> matriculas, List<Curso> cursosProf,
			List<Noticia> noticias) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.foto = foto;
		this.comentarios = comentarios;
		this.matriculas = matriculas;
		this.cursosProf = cursosProf;
		this.noticias = noticias;
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
	public List<Curso> getCursosProf() {
		return cursosProf;
	}
	public void setCursosProf(List<Curso> cursosProf) {
		this.cursosProf = cursosProf;
	}
	public List<Noticia> getNoticias() {
		return noticias;
	}
	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + ", nombre=" + nombre + ", apellidos=" + apellidos + ", foto=" + foto + ", comentarios="
				+ comentarios + ", matriculas=" + matriculas + ", cursosProf=" + cursosProf + ", noticias=" + noticias
				+ "]";
	}
	
	
}
