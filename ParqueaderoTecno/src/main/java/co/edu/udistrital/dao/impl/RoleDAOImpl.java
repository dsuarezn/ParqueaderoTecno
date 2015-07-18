package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.RoleDAO;
import co.edu.udistrital.entidades.Role;

@Repository
@Qualifier("roleDAOImpl")
public class RoleDAOImpl extends GenericDAOJPAImpl<Role, String> implements RoleDAO {

	@Override
	public List<Role> findAllRoles() {
		Query query = em.createNamedQuery("Role.findAll");		
		List<Role> listaroles = (List<Role>) query.getResultList();
		return listaroles;
	}

}
