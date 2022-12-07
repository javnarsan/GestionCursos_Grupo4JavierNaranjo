package com.example.demo.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UsuarioService;

@Service("userService")
public class UserService implements UserDetailsService,UsuarioService{
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		com.example.demo.entities.User usuario=userRepository.findByEmail(email);
		System.err.print(usuario.getEmail().toString());
		System.err.print(usuario.getPassword().toString());
		UserBuilder builder=null;
		UserDetails user=null;
		if(email!=null) {
			//forma para usar email como usuario en el login
			user= User.withUsername(usuario.getEmail()).password(usuario.getPassword()).disabled(false).authorities(usuario.getRole()).build();
			/*builder=User.builder().authorities(email);
			builder.disabled(false);
			builder.password(usuario.getPassword());
			builder.authorities(new SimpleGrantedAuthority(usuario.getRole()));*/
		}
		else 
			throw new UsernameNotFoundException("Usuario no encontrado");
			
		return user;
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	public com.example.demo.entities.User registrar(com.example.demo.entities.User user){
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		user.setEnabled(false);
		user.setRole("ROLE_ALUMNO");
		return userRepository.save(user);
	}

	@Override
	public List<com.example.demo.entities.User> listAllUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
}
