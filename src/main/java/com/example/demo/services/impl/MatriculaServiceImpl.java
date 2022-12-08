package com.example.demo.services.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Matricula;
import com.example.demo.models.MatriculaModel;
import com.example.demo.repositories.MatriculaRepository;
import com.example.demo.services.MatriculaService;

@Service("matriculaService")
public class MatriculaServiceImpl implements MatriculaService{
	@Autowired
	@Qualifier("matriculaRepository")
	private MatriculaRepository matriculaRepository;
	
	
	@Override
	public List<MatriculaModel> listAllMatriculas() {
		// TODO Auto-generated method stub
		return matriculaRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Matricula addMatricula(MatriculaModel matriculaModel) {
		// TODO Auto-generated method stub
		return matriculaRepository.save(transform(matriculaModel));
	}

	@Override
	public int removeMatricula(int id) {
		// TODO Auto-generated method stub
		matriculaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Matricula updateMatricula(MatriculaModel matriculaModel) {
		// TODO Auto-generated method stub
		return matriculaRepository.save(transform(matriculaModel));
	}

	@Override
	public Matricula transform(MatriculaModel matriculaModel) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(matriculaModel, Matricula.class);
	}

	@Override
	public MatriculaModel transform(Matricula matricula) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(matricula, MatriculaModel.class);
	}

	@Override
	public MatriculaModel findMatricula(int id) {
		// TODO Auto-generated method stub
		return transform(matriculaRepository.findById(id).orElse(null));
	}

}
