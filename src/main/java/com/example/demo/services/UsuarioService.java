package com.example.demo.services;

import java.util.List;


import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
public interface UsuarioService {
	public abstract List<User> listAllUsuarios();
	public abstract User transform(UserModel userModel);
	public abstract UserModel transform(User user);
	
}
