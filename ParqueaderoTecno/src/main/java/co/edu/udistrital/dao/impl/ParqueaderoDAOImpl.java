package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.ParqueaderoDAO;
import co.edu.udistrital.entidades.Parqueadero;

@Repository
@Qualifier("parqueaderoDAOImpl")
public class ParqueaderoDAOImpl extends GenericDAOJPAImpl<Parqueadero, String> implements ParqueaderoDAO {

	public List<Parqueadero> findAllParqueaderos() throws PersistenceException {
		Query query = em.createNamedQuery("Parqueadero.findAll");		
		@SuppressWarnings("unchecked")
		List<Parqueadero> listaParqueadero = (List<Parqueadero>) query.getResultList();
		return listaParqueadero;
	}

	@Override
	public Parqueadero findParqueaderosByTipo(String tipoParqueadero) throws PersistenceException {
		Query query = em.createNamedQuery("Parqueadero.findByTipo");
		query.setParameter("tipo", tipoParqueadero);
		Parqueadero parqueadero = (Parqueadero) query.getSingleResult();
		return parqueadero;
	}
}
