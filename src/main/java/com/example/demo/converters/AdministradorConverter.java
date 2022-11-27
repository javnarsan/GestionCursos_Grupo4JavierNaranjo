package com.example.demo.converters;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Administrador;
import com.example.demo.models.AdministradorModel;



@Component("administradorConverter")
public class AdministradorConverter {
	public AdministradorModel entity2model(Administrador admin) {
		AdministradorModel adminModel=new AdministradorModel();
		adminModel.setIdAdministrador(admin.getIdAdministrador());
		adminModel.setUsuario(admin.getUsuario());
		adminModel.setPassword(admin.getPassword());
		return adminModel;
	}
	public Administrador model2entity(AdministradorModel adminModel) {
		Administrador admin=new Administrador();
		admin.setIdAdministrador(adminModel.getIdAdministrador());
		admin.setUsuario(adminModel.getUsuario());
		admin.setPassword(adminModel.getPassword());
		return admin;
		
	}

}
