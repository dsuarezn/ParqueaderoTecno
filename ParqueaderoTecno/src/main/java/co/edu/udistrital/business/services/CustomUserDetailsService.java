package co.edu.udistrital.business.services;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.security.core.userdetails.UserDetailsService;

import co.edu.udistrital.entidades.User;



public interface CustomUserDetailsService extends UserDetailsService {

	public List<User> findAllUsers() throws PersistenceException;
	
	public User crearUsuario(User usuario) throws PersistenceException;
	
	public User actualizarUsuario(User usuario) throws PersistenceException;
	
	public void borrarUsuario(User usuario) throws PersistenceException;
	

}
