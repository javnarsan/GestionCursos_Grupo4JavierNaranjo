package com.example.demo.services;

import java.util.List;


import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
public interface UsuarioService {
	public abstract List<UserModel> listAllProfesores();
	public abstract List<UserModel> listAllStudents();
	public abstract int removeProfesor(long id);
	public abstract User addProfesor(UserModel profesorModel);
	public abstract User updateProfesor(UserModel profesorModel);
	public abstract UserModel findProfesor(long id);
	public abstract User transform(UserModel userModel);
	public abstract UserModel transform(User user);
	
}
