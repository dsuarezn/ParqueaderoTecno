package co.edu.udistrital.business.services;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import co.edu.udistrital.entidades.Parqueadero;

public interface CustomParqueaderoDetailService {

	public Parqueadero loadParqueaderoByTipo(String tipoParqueadero) throws UsernameNotFoundException, PersistenceException ;

	public List<Parqueadero> findAllParqueaderos() throws PersistenceException;

	public Parqueadero crearParqueadero(Parqueadero parqueadero) throws PersistenceException;
	
	public Parqueadero actualizarParqueadero(Parqueadero parqueadero) throws PersistenceException;
	
	public void borrarParqueadero(Parqueadero parqueadero) throws PersistenceException;
}
