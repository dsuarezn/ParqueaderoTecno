package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.Propietario;

public interface PropietarioDAO extends GenericDAOInterface<Propietario, Long> {
	
	public Propietario findPropietarioByCC(long cedula) throws PersistenceException;
	public List<Propietario> findAllPropietarios() throws PersistenceException;
	public Propietario findPropietariosById(Long id) throws PersistenceException;
}
