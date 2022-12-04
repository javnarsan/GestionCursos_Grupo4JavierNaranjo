/*package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Profesor;
import com.example.demo.models.ProfesorModel;
import com.example.demo.repositories.ProfesorRepository;
import com.example.demo.services.ProfesorService;

@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService {
@Autowired
@Qualifier("profesorRepository")
private ProfesorRepository profesorRepository;

public List<ProfesorModel> listAllProfesores() {
	return profesorRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
}

public Profesor addProfesor(ProfesorModel profesorModel) {
	// TODO Auto-generated method stub
	return profesorRepository.save(transform(profesorModel));
}

public int removeProfesor(int id) {
	// TODO Auto-generated method stub
	 profesorRepository.deleteById(id);
	 return 0;
	
}

public Profesor updateProfesor(ProfesorModel profesorModel) {
	// TODO Auto-generated method stub
	return profesorRepository.save(transform(profesorModel));
}


public Profesor transform(ProfesorModel profesorModel) {
	// TODO Auto-generated method stub
	ModelMapper modelMapper=new ModelMapper();
	return modelMapper.map(profesorModel, Profesor.class);
}


public ProfesorModel transform(Profesor profesor) {
	// TODO Auto-generated method stub
	ModelMapper modelMapper=new ModelMapper();
	return modelMapper.map(profesor, ProfesorModel.class);
}


public ProfesorModel findProfesor(int id) {
	// TODO Auto-generated method stub
	return transform(profesorRepository.findById(id).orElse(null));
}
	
}*/
