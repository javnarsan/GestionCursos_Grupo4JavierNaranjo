package com.example.demo.services.impl;

import java.util.List;
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
		return cursoRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
	}
	
	@Override
	public Curso addCurso(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		return cursoRepository.save(transform(cursoModel));
	}
	
	@Override
	public int removeCurso(int id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
		return 0;
	}
	
	@Override
	public Curso updateCurso(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		return cursoRepository.save(transform(cursoModel));
	}
	
	@Override
	public Curso transform(CursoModel cursoModel) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(cursoModel, Curso.class);
	}
	
	@Override
	public CursoModel transform(Curso curso) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(curso, CursoModel.class);
	}
	
	@Override
	public CursoModel findCurso(int id) {
		// TODO Auto-generated method stub
		return transform(cursoRepository.findById(id).orElse(null));
	}



	
}
