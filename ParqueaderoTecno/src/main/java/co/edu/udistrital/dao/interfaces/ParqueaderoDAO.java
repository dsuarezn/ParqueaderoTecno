package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.Parqueadero;

public interface ParqueaderoDAO extends GenericDAOInterface<Parqueadero, String> {

	public List<Parqueadero> findAllParqueaderos() throws PersistenceException ;
	public Parqueadero findParqueaderosByTipo(String tipoParqueadero) throws PersistenceException ;

}
