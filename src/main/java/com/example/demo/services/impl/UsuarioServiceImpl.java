package com.example.demo.services.impl;

import java.util.ArrayList;
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
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public List<UserModel> listAllProfesores() {
		// TODO Auto-generated method stub
		return userRepository.findAll().stream().filter(c -> "ROLE_PROFESOR".equals(c.getRole())).map(c -> transform(c))
				.collect(Collectors.toList());
	}

	@Override
	public User transform(UserModel userModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userModel, User.class);
	}

	@Override
	public UserModel transform(User user) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(user, UserModel.class);
	}

	@Override
	public int removeProfesor(long id) {
		userRepository.deleteById(id);
		return 0;
	}

	@Override
	public List<UserModel> listAllStudents() {
		return userRepository.findAll().stream().filter(c -> "ROLE_ALUMNO".equals(c.getRole())).map(c -> transform(c))
				.collect(Collectors.toList());
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
	public User findUserById(long id) {
		return userRepository.findUserById(id);
	}

	@Override
	public User activarEstudiante(UserModel usuarioModel) {
		usuarioModel.setEnabled(true);
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public User desactivarEstudiante(UserModel usuarioModel) {
		usuarioModel.setEnabled(false);
		return userRepository.save(transform(usuarioModel));
	}

	@Override
	public void borrarEstudiante(int id) {
		User usuario = userRepository.findUserById(id);
		userRepository.delete(usuario);
	}

	@Override
	public boolean existeEmail(String email) {
		boolean Existe=false;
		List<UserModel> listaAlumnos = userRepository.findAll().stream().map(c -> transform(c)).collect(Collectors.toList());
		for (UserModel usermodel : listaAlumnos) {
			if (usermodel.getEmail().equals(email)) {
				Existe = true;
				break;
			}
		}
		return Existe;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
}
