package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.entidades.User;

public interface PropietarioDAO extends GenericDAOInterface<Propietario, Long> {
	public List<Propietario> findAllPropietarios() throws PersistenceException;
}
