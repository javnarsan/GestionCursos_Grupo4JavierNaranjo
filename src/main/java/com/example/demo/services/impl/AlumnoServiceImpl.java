/*package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Alumno;
import com.example.demo.models.AlumnoModel;
import com.example.demo.repositories.AlumnoRepository;
import com.example.demo.services.AlumnoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService {
@Autowired
@Qualifier("alumnoRepository")
private AlumnoRepository alumnoRepository;

public List<AlumnoModel> listAllAlumnos() {
	return alumnoRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
}

public Alumno addAlumno(AlumnoModel alumnoModel) {
	// TODO Auto-generated method stub
	return alumnoRepository.save(transform(alumnoModel));
}

public int removeAlumnot(int id) {
	// TODO Auto-generated method stub
	 alumnoRepository.deleteById(id);
	 return 0;
	
}

public Alumno updateAlumno(AlumnoModel alumnoModel) {
	// TODO Auto-generated method stub
	return alumnoRepository.save(transform(alumnoModel));
}


public Alumno transform(AlumnoModel alumnoModel) {
	// TODO Auto-generated method stub
	ModelMapper modelMapper=new ModelMapper();
	return modelMapper.map(alumnoModel, Alumno.class);
}


public AlumnoModel transform(Alumno alumno) {
	// TODO Auto-generated method stub
	ModelMapper modelMapper=new ModelMapper();
	return modelMapper.map(alumno, AlumnoModel.class);
}


public AlumnoModel finAlumno(int id) {
	// TODO Auto-generated method stub
	return transform(alumnoRepository.findById(id).orElse(null));
}
	
}*/
