package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdministrador;
	private String nombre;
	private String descripcion;
	private int nivel;
	private int idProfesor;
	private String fechaInicio;
	private String fechaFin;
}