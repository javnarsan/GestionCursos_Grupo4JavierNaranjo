package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Curso;
import com.example.demo.models.CursoModel;
import com.example.demo.repositories.CursoRepository;
import com.example.demo.services.CursoService;


@Service("cursoService")
public class CursoServiceImpl implements CursoService {
@Autowired
@Qualifier("cursoRepository")
private CursoRepository cursoRepository;

@Override
public List<CursoModel> listAllCursos() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Curso addCurso(CursoModel cursoModel) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int removeCursot(int id) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Curso updateCurso(CursoModel cursoModel) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Curso transform(CursoModel cursoModel) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CursoModel transform(Curso curso) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CursoModel findCurso(int id) {
	// TODO Auto-generated method stub
	return null;
}



	
}
