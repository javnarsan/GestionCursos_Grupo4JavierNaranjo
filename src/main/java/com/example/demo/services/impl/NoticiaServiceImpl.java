package com.example.demo.services.impl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Noticia;
import com.example.demo.models.NoticiaModel;
import com.example.demo.repositories.NoticiaRepository;
import com.example.demo.services.NoticiaService;
import com.example.demo.services.StrorageService;


@Service("noticiaService")
public class NoticiaServiceImpl implements NoticiaService{

	@Autowired
	@Qualifier("noticiaRepository")
	private NoticiaRepository noticiaRepository;
	
	@Autowired
	@Qualifier("strorageService")
	private StrorageService strorageService;
	
	
	@Override
	public List<NoticiaModel> listAllNoticias() {
		// TODO Auto-generated method stub
		return noticiaRepository.findAll().stream().map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public Noticia addNoticia(NoticiaModel noticiaModel) {
		LocalDateTime datetime = LocalDateTime.now();
		noticiaModel.setFechaCreacion(datetime);
		return noticiaRepository.save(transform(noticiaModel));
	}

	@Override
	public int removeNoticia(int id) {
		// TODO Auto-generated method stub
		String img=noticiaRepository.findById(id).get().getImagen();
		strorageService.eliminarArchivo(img);
		noticiaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Noticia updateNoticia(NoticiaModel noticiaModel) {
		// TODO Auto-generated method stub
		LocalDateTime datetime = LocalDateTime.now();
		noticiaModel.setFechaCreacion(datetime);
		return noticiaRepository.save(transform(noticiaModel));
	}

	@Override
	public Noticia transform(NoticiaModel noticiaModel) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(noticiaModel, Noticia.class);
	}

	@Override
	public NoticiaModel transform(Noticia noticia) {
		// TODO Auto-generated method stub
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(noticia, NoticiaModel.class);
	}

	@Override
	public NoticiaModel findNoticia(int id) {
		// TODO Auto-generated method stub
		return transform(noticiaRepository.findById(id).orElse(null));
	}

}
