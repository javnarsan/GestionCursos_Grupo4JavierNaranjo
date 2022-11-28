package com.example.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.entities.Comentario;
import com.example.demo.entities.Matricula;

public class AlumnoModel {
	private int idAlumno;
	private String nombre;
	private String apellidos;
	private String email;
	private String usuario;
	private String password;
	private String foto;
	private List<Comentario> comentarios;
	private List<Matricula> matriculas;
	public AlumnoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AlumnoModel(int idAlumno, String nombre, String apellidos, String email, String usuario, String password,
			String foto, List<Comentario> comentarios, List<Matricula> matriculas) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.password = password;
		this.foto = foto;
		this.comentarios = comentarios;
		this.matriculas = matriculas;
	}
	public int getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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
	@Override
	public String toString() {
		return "AlumnoModel [idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email="
				+ email + ", usuario=" + usuario + ", password=" + password + ", foto=" + foto + ", comentarios="
				+ comentarios + ", matriculas=" + matriculas + "]";
	}
	
}
