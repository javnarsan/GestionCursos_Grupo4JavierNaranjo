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
	public int removeProfesor(long id) {
		userRepository.deleteById(id);
		return 0;
	}

	@Override
	public List<UserModel> listAllStudents() {
		return userRepository.findAll().stream().filter(c->"ROLE_ALUMNO".equals(c.getRole())).map(c->transform(c)).collect(Collectors.toList());
	}
	@Override
	public User addProfesor(UserModel profesorModel) {
		profesorModel.setRole("ROLE_PROFESOR");
		profesorModel.setPassword(UserService.passwordEncoder().encode(profesorModel.getPassword()));
		return userRepository.save(transform(profesorModel));
	}

	@Override
	public User updateProfesor(UserModel profesorModel) {
		profesorModel.setRole("ROLE_PROFESOR");
		profesorModel.setPassword(UserService.passwordEncoder().encode(profesorModel.getPassword()));
		return userRepository.save(transform(profesorModel));
	}

	@Override
	public UserModel findProfesor(long id) {
		return transform(userRepository.findById(id).orElse(null));
	}

	@Override
	public int activarEstudiante(UserModel estuanteModel,int id) {
		userRepository.findById(id).get().setEnabled(true);
		estuanteModel.setEnabled(true);
		userRepository.save(transform(estuanteModel));
		return 0;
	}

	@Override
	public int desactivarEstudiante(UserModel estuanteModel,int id) {
		userRepository.findById(id).get().setEnabled(false);
		estuanteModel.setEnabled(false);
		userRepository.save(transform(estuanteModel));
		return 0;
	}

}
