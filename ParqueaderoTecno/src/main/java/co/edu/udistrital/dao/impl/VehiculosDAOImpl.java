package co.edu.udistrital.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.PropietarioDAO;
import co.edu.udistrital.dao.interfaces.VehiculosDAO;
import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.entidades.Vehiculo;

@Repository
@Qualifier("vehiculosDAOImpl")
public class VehiculosDAOImpl extends GenericDAOJPAImpl<Vehiculo, String> implements VehiculosDAO{
	

	@Override
	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long cedula)
			throws PersistenceException {
			Query query = em.createNamedQuery("Vehiculo.findByCedula");
			query.setParameter("cedula", cedula);
			List<Vehiculo> listavehiculos = (List<Vehiculo>) query.getResultList();
			return listavehiculos;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiculo> findAllVehiculos() throws PersistenceException {
		Query query = em.createNamedQuery("Vehiculo.findAll");		
		List<Vehiculo> listavehiculos = (List<Vehiculo>) query.getResultList();
		return listavehiculos;
	}
	

	@Override
	public Vehiculo findVehiculoByPLaca(String placa) throws PersistenceException {
		Query query = em.createNamedQuery("Vehiculo.findByPlaca");
		query.setParameter("placa", placa);
		Vehiculo vehiculo = (Vehiculo) query.getSingleResult();
		return vehiculo;
	}

}
