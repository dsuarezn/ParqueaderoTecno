package co.edu.udistrital.business.services.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.udistrital.business.services.RoleService;
import co.edu.udistrital.dao.DAOFactory;
import co.edu.udistrital.entidades.Role;
import co.edu.udistrital.entidades.User;

@Transactional
@Service
@Qualifier("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private DAOFactory daoFactory;

	@Override
	public List<Role> buscarTodosRoles() {
		return daoFactory.getRoleDAOImpl().findAllRoles();
	}

		
	


}
