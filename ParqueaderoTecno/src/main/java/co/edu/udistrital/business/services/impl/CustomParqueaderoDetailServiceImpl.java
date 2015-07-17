package co.edu.udistrital.business.services.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.business.services.CustomParqueaderoDetailService;
import co.edu.udistrital.dao.DAOFactory;
import co.edu.udistrital.entidades.Parqueadero;

@Transactional
@Service
@Qualifier("CustomParqueaderoDetailServiceImpl")
public class CustomParqueaderoDetailServiceImpl implements CustomParqueaderoDetailService{

	@Autowired
	private DAOFactory daoFactory;	

	
	public Parqueadero loadParqueaderoByTipo(String tipoParqueadero) throws UsernameNotFoundException, PersistenceException {
		Parqueadero parqueadero = daoFactory.getParqueaderoDAOImpl().findParqueaderosByTipo(tipoParqueadero);		
		if(parqueadero==null){
			throw new NotFoundException("ParqueaderoNotFoundException");
		}		
		return parqueadero;
	}
	
	public List<Parqueadero> findAllParqueaderos() throws PersistenceException {
		List<Parqueadero> listParqueaderos = daoFactory.getParqueaderoDAOImpl().findAllParqueaderos();		
		return listParqueaderos;
		
	}

	@Override
	public Parqueadero crearParqueadero(Parqueadero parqueadero)
			throws PersistenceException {
		
		return daoFactory.getParqueaderoDAOImpl().create(parqueadero);
	}

	@Override
	public Parqueadero actualizarParqueadero(Parqueadero parqueadero)
			throws PersistenceException {
		return daoFactory.getParqueaderoDAOImpl().update(parqueadero);
	}

	@Override
	public void borrarParqueadero(Parqueadero parqueadero)
			throws PersistenceException {
		daoFactory.getParqueaderoDAOImpl().delete(parqueadero);		
	}

	
}
