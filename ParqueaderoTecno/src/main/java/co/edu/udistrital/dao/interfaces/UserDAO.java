package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.dao.impl.UserDAOImpl;
import co.edu.udistrital.entidades.User;

public interface UserDAO extends GenericDAOInterface<UserDAOImpl, String> {

	public User findUserByName(String name) throws PersistenceException;
	
}
