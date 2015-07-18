package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.User;

public interface UserDAO extends GenericDAOInterface<User, String> {

	public User findUserByName(String name) throws PersistenceException;
	public List<User> findAllUsers() throws PersistenceException;
	
}
