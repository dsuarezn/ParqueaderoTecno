package co.edu.udistrital.business.services;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import co.edu.udistrital.entidades.Propietario;


public interface PropietarioService {
	
	public Propietario findPropietarioById(Long Id) throws PersistenceException;
	
	public List<Propietario> findAllPropietarios() throws PersistenceException;
	
	public Propietario crearPropietario(Propietario propietario) throws PersistenceException;

	public Propietario actualizarPropietario(Propietario propietario) throws PersistenceException;
	
	public void borrarPropietario(Propietario propietario) throws PersistenceException;
	
	public Propietario buscarPropietarioPorCedula(long cedula) throws PersistenceException;

}
