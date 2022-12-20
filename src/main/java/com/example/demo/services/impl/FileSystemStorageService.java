package com.example.demo.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.exceptions.AlmacenExcepcion;
import com.example.demo.exceptions.FileNotFoundException;
import com.example.demo.services.StrorageService;

import org.springframework.core.io.Resource;


@Service("strorageService")
public class FileSystemStorageService implements StrorageService {
	
	@Value("${storage.location}")
	private String storageLocation;

  @Override
	public void iniciarAlmacenDeArchivos() {
		try {
			Files.createDirectories(Paths.get(storageLocation));
		}catch (IOException excepcion) {
			throw new AlmacenExcepcion("Error al inicializar la ubicación en el almacen de archivos");
		}
		
	}

	@Override
	public String almacenarArchivo(MultipartFile archivo,String titulo) {
		String nombreArchivo = titulo+"."+archivo.getOriginalFilename().substring(archivo.getOriginalFilename().lastIndexOf(".") + 1);
		if(archivo.isEmpty()) {
			throw new AlmacenExcepcion("No se puede almacenar un archivo vacio");
		}
		try {
			InputStream inputStream  = archivo.getInputStream();
			Files.copy(inputStream,Paths.get(storageLocation).resolve(nombreArchivo),StandardCopyOption.REPLACE_EXISTING);
		}catch (IOException excepcion) {
			throw new AlmacenExcepcion("Error al almacenar el archivo " + nombreArchivo,excepcion);
		}
		return nombreArchivo;
	}

	@Override
	public Path cargarArchivo(String nombreArchivo) {
		return Paths.get(storageLocation).resolve(nombreArchivo);
	}

	@Override
	public Resource cargarComoRecurso(String nombreArchivo) {
		try {
			Path archivo = cargarArchivo(nombreArchivo);
			Resource recurso = new UrlResource(archivo.toUri());
			
			if(recurso.exists() || recurso.isReadable()) {
				return recurso;
			}else {
				throw new FileNotFoundException("No se pudo encontrar el archivo " + nombreArchivo);
			}
		
		}catch (MalformedURLException excepcion) {
			throw new FileNotFoundException("No se pudo encontrar el archivo " + nombreArchivo,excepcion);
		}
	}

	@Override
	public void eliminarArchivo(String nombreArchivo) {
		Path archivo = cargarArchivo(nombreArchivo);
		try {
			FileSystemUtils.deleteRecursively(archivo);
		}catch (Exception excepcion) {
			System.out.println(excepcion);
		}
		
	}
}