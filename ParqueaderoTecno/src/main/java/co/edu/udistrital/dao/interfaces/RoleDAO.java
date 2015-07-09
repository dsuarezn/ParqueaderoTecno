package co.edu.udistrital.dao.interfaces;

import java.util.List;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.Role;

public interface RoleDAO extends GenericDAOInterface<Role, String> {

	public List<Role> findAllRoles();
	
}
