package co.edu.udistrital.business.services.impl;


import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.business.services.PropietarioService;
import co.edu.udistrital.entidades.Propietario;


@Transactional
@Service
@Qualifier("propietarioServiceImpl")
public class PropietarioServiceImpl extends ServiceCommons implements PropietarioService {
	
	@Override
	public List<co.edu.udistrital.entidades.Propietario> findAllPropietarios() throws PersistenceException {
		List<co.edu.udistrital.entidades.Propietario> listapropietario = daoFactory.getPropietarioDAOImpl().findAllPropietarios();
		return listapropietario;
	}

	@Override
	public co.edu.udistrital.entidades.Propietario crearPropietario(co.edu.udistrital.entidades.Propietario propietario) throws PersistenceException {
		return daoFactory.getPropietarioDAOImpl().create(propietario);		
	}

	@Override
	public co.edu.udistrital.entidades.Propietario actualizarPropietario(co.edu.udistrital.entidades.Propietario propietario) throws PersistenceException {		
			return daoFactory.getPropietarioDAOImpl().update(propietario);
	}

	public void borrarPropietario(co.edu.udistrital.entidades.Propietario propietario) throws PersistenceException {
		daoFactory.getPropietarioDAOImpl().delete(propietario);
	}
	public co.edu.udistrital.entidades.Propietario buscarPropietarioPorCedula(long cedula) throws PersistenceException {
		return daoFactory.getPropietarioDAOImpl().findPropietarioByCC(cedula);
	}
	@Override
	public Propietario findPropietarioById(Long Id)
			throws PersistenceException {
		return daoFactory.getPropietarioDAOImpl().findPropietariosById(Id);
		
	}
}
