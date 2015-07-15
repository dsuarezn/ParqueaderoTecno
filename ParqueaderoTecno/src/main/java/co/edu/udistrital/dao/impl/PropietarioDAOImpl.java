package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.PropietarioDAO;
import co.edu.udistrital.entidades.Propietario;

@Repository
@Qualifier("propietarioDAOImpl")
public class PropietarioDAOImpl extends GenericDAOJPAImpl<Propietario, Long> implements PropietarioDAO{
	
	@Override
	public Propietario findPropietarioByCC(long cedula) throws PersistenceException {
		Query query = em.createNamedQuery("Propietario.findByCC");
		query.setParameter("cedula", cedula);
		Propietario propietario = (Propietario) query.getSingleResult();
		return propietario;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Propietario> findAllPropietarios() throws PersistenceException {
		Query query = em.createNamedQuery("Propietario.findAll");		
		List<Propietario> listapropietario = (List<Propietario>) query.getResultList();
		return listapropietario;
	}

}
