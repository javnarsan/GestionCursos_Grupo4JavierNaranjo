package com.example.demo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UsuarioService;
@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	@Override
	public List<UserModel> listAllProfesores() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream().filter(c->"ROLE_PROFESOR".equals(c.getRole())).map(c->transform(c)).collect(Collectors.toList());
	}

	@Override
	public User transform(UserModel userModel) {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(userModel, User.class);
	}

	@Override
	public UserModel transform(User user) {
		ModelMapper modelMapper=new ModelMapper();
		return modelMapper.map(user, UserModel.class);
	}

	@Override
	public int removeProfesor(int id) {
		userRepository.deleteById(id);
		return 0;
	}

	@Override
	public List<UserModel> listAllStudents() {
		return userRepository.findAll().stream().filter(c->"ROLE_ALUMNO".equals(c.getRole())).map(c->transform(c)).collect(Collectors.toList());
	}

}
