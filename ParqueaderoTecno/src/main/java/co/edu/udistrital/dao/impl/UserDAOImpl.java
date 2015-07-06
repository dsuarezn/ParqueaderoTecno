package co.edu.udistrital.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.UserDAO;
import co.edu.udistrital.entidades.User;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Repository
@Qualifier("userDAOImpl")
public class UserDAOImpl extends GenericDAOJPAImpl<UserDAOImpl, String> implements UserDAO{

	@Override
	public User findUserByName(String name) throws PersistenceException {
		Query query = em.createNamedQuery("User.findByName");
		query.setParameter("name", name);
		User user = (User) query.getSingleResult();
		return user;
	}
	
}
