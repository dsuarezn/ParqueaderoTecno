package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.VehiculosDAO;
import co.edu.udistrital.entidades.Vehiculo;

@Repository
@Qualifier("vehiculosDAOImpl")
public class VehiculosDAOImpl extends GenericDAOJPAImpl<Vehiculo, String> implements VehiculosDAO {

	@Override
	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long cedula)
			throws PersistenceException {
			Query query = em.createNamedQuery("Vehiculo.findByCedula");
			query.setParameter("cedula", cedula);
			List<Vehiculo> listauser = (List<Vehiculo>) query.getResultList();
			return listauser;
	}

	@Override
	public Vehiculo obtenerVehiculosPorPlaca(String placa)
			throws PersistenceException {
		return em.find(Vehiculo.class, placa);		
	}

}
