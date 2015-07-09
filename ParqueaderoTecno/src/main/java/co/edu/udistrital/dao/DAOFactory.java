package co.edu.udistrital.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.impl.IngresosDAOImpl;
import co.edu.udistrital.dao.impl.ParqueaderoDAOImpl;
import co.edu.udistrital.dao.impl.PropietarioDAOImpl;
import co.edu.udistrital.dao.impl.RoleDAOImpl;
import co.edu.udistrital.dao.impl.UserDAOImpl;
import co.edu.udistrital.dao.impl.VehiculosDAOImpl;
import co.edu.udistrital.dao.interfaces.IngresosDAO;
import co.edu.udistrital.dao.interfaces.ParqueaderoDAO;
import co.edu.udistrital.dao.interfaces.PropietarioDAO;
import co.edu.udistrital.dao.interfaces.RoleDAO;
import co.edu.udistrital.dao.interfaces.UserDAO;
import co.edu.udistrital.dao.interfaces.VehiculosDAO;


@Repository
@Qualifier("daoFactory")
public class DAOFactory {
	//TODO: evaluar porque se podria o no hacer estaticos los DAOs
	public DAOFactory() {
		super();
	
	}
	@Autowired
	private IngresosDAO ingresosDAOImpl;
	
	@Autowired
	private ParqueaderoDAO parqueaderoDAOImpl;
	
	@Autowired
	private PropietarioDAO propietarioDAOImpl;
	
	@Autowired
	private VehiculosDAO vehiculosDAOImpl;
	
	@Autowired
	private UserDAO userDAOImpl;
	
	@Autowired
	private RoleDAO roleDAOImpl;

	public IngresosDAO getIngresosDAOImpl() {
		return ingresosDAOImpl;
	}

	public ParqueaderoDAO getParqueaderoDAOImpl() {
		return parqueaderoDAOImpl;
	}

	public PropietarioDAO getPropietarioDAOImpl() {
		return propietarioDAOImpl;
	}

	public VehiculosDAO getVehiculosDAOImpl() {
		return vehiculosDAOImpl;
	}

	public UserDAO getUserDAOImpl() {
		return userDAOImpl;
	}

	public RoleDAO getRoleDAOImpl() {
		return roleDAOImpl;
	}

	
	


		

}
