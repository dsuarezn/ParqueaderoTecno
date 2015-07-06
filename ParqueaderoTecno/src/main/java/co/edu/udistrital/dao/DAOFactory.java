package co.edu.udistrital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.entityex.IngresosDAO;
import co.edu.udistrital.dao.entityex.ParqueaderoDAO;
import co.edu.udistrital.dao.entityex.PropietarioDAO;
import co.edu.udistrital.dao.entityex.RoleDAO;
import co.edu.udistrital.dao.entityex.UserDAO;
import co.edu.udistrital.dao.entityex.VehiculosDAO;


@Repository
@Qualifier("DAOFactory")
public class DAOFactory {
	//TODO: evaluar porque se podria o no hacer estaticos los DAOs
	public DAOFactory() {
		super();
	
	}
	@Autowired
	private IngresosDAO ingresosDAO;
	
	@Autowired
	private ParqueaderoDAO parqueaderoDAO;
	
	@Autowired
	private PropietarioDAO propietarioDAO;
	
	@Autowired
	private VehiculosDAO vehiculosDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;

	public IngresosDAO getIngresosDAO() {
		return ingresosDAO;
	}

	public ParqueaderoDAO getParqueaderoDAO() {
		return parqueaderoDAO;
	}

	public PropietarioDAO getPropietarioDAO() {
		return propietarioDAO;
	}

	public VehiculosDAO getVehiculosDAO() {
		return vehiculosDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}
		

}
