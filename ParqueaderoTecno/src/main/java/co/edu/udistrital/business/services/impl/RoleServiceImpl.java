package co.edu.udistrital.business.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.udistrital.business.services.RoleService;
import co.edu.udistrital.entidades.Role;

@Transactional
@Service
@Qualifier("roleServiceImpl")
public class RoleServiceImpl extends ServiceCommons implements RoleService {

	
	@Override
	public List<Role> buscarTodosRoles() {
		return daoFactory.getRoleDAOImpl().findAllRoles();
	}

		
	


}
