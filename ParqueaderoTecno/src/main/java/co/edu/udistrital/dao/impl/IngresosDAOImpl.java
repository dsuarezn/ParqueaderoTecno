package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.IngresosDAO;
import co.edu.udistrital.entidades.Ingreso;
import co.edu.udistrital.web.dto.RegistroFormDTO;

@Repository
@Qualifier("ingresosDAOImpl")
public class IngresosDAOImpl extends GenericDAOJPAImpl<Ingreso, Long> implements IngresosDAO {

	@Override
	public Ingreso findIngresoActivoByPlaca(String placa) throws PersistenceException {
		Query query = em.createNamedQuery("Ingreso.findActivoById");
		query.setParameter("placa", placa);
		Ingreso ingreso=null;
		try {
			ingreso=(Ingreso) query.getSingleResult();
		} catch (NoResultException e) {
			ingreso=null;
		}		
		return ingreso;
	}

	@Override
	public List<Ingreso> findIngresoByFilters(RegistroFormDTO filtrodto)
			throws PersistenceException {
		Query query = em.createNamedQuery("Ingreso.findIngresoByBasicFilters");
		query.setParameter("estado", filtrodto.getEstado());
		query.setParameter("placa", filtrodto.getPlaca());
		query.setParameter("fechaIngreso",null/*filtrodto.getFechaInicio()*/);
		query.setParameter("fechaFin",null /*filtrodto.getFechaFin()*/);
		return  query.getResultList();
	}

		
	
	
}
