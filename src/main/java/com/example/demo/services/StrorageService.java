package com.example.demo.services;

import java.nio.file.Path;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StrorageService{
	public void iniciarAlmacenDeArchivos();
	public String almacenarArchivo(MultipartFile archivo,String titulo);
	public Path cargarArchivo(String nombreArchivo);
	public Resource cargarComoRecurso(String nombreArchivo);
	public void eliminarArchivo(String nombreArchivo);
}
