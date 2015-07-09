package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.UserDAO;
import co.edu.udistrital.entidades.User;


@Repository
@Qualifier("userDAOImpl")
public class UserDAOImpl extends GenericDAOJPAImpl<User, String> implements UserDAO{

	@Override
	public User findUserByName(String name) throws PersistenceException {
		Query query = em.createNamedQuery("User.findByName");
		query.setParameter("name", name);
		User user = (User) query.getSingleResult();
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() throws PersistenceException {
		Query query = em.createNamedQuery("User.findAll");		
		List<User> listauser = (List<User>) query.getResultList();
		return listauser;
	}
	
}
