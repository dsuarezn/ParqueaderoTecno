package co.edu.udistrital.business.services;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.entidades.Propietario;


public interface PropietarioService {
	
	public Propietario findPropietarioById(Long Id) throws PersistenceException;
	
	public List<Propietario> findAllPropietarios() throws PersistenceException;
	
	public Propietario crearPropietario(Propietario propietario) throws PersistenceException;
	
	/*public User actualizarUsuario(User usuario) throws PersistenceException;
	
	public void borrarUsuario(User usuario) throws PersistenceException;*/

}
