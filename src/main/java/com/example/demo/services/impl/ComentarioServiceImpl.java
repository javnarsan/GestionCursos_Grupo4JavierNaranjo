package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Comentario;
import com.example.demo.models.ComentarioModel;
import com.example.demo.repositories.ComentarioRepository;
import com.example.demo.services.ComentarioService;

@Service("comentarioService")
public class ComentarioServiceImpl implements ComentarioService {
@Autowired
@Qualifier("comentarioRepository")
private ComentarioRepository comentarioRepository;

public List<ComentarioModel> listAllComentarios() {
	return comentarioRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
}

public Comentario addComentario(ComentarioModel comentarioModel) {
	// TODO Auto-generated method stub
	return comentarioRepository.save(transform(comentarioModel));
}

public int removeComentario(int id) {
	// TODO Auto-generated method stub
	 comentarioRepository.deleteById(id);
	 return 0;
	
}

public Comentario updateAlumno(ComentarioModel comentarioModel) {
	// TODO Auto-generated method stub
	return comentarioRepository.save(transform(comentarioModel));
}


public Comentario transform(ComentarioModel comentarioModel) {
	// TODO Auto-generated method stub
	ModelMapper modelMapper=new ModelMapper();
	return modelMapper.map(comentarioModel, Comentario.class);
}


public ComentarioModel transform(Comentario comentario) {
	// TODO Auto-generated method stub
	ModelMapper modelMapper=new ModelMapper();
	return modelMapper.map(comentario, ComentarioModel.class);
}


public ComentarioModel findComentario(int id) {
	// TODO Auto-generated method stub
	return transform(comentarioRepository.findById(id).orElse(null));
}
	
}
