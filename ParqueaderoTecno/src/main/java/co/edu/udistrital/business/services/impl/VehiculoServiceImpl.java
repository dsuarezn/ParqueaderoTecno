package co.edu.udistrital.business.services.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.udistrital.business.services.VehiculoService;
import co.edu.udistrital.entidades.Vehiculo;

@Transactional
@Service
@Qualifier("vehiculoServiceImpl")
public class VehiculoServiceImpl extends ServiceCommons implements VehiculoService {
	

	@Override
	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long identificacion) throws PersistenceException {
		return daoFactory.getVehiculosDAOImpl().obtenerVehiculosPorIdentificacion(identificacion);
	}

	@Override
	public List<Vehiculo> findAllVehiculos() throws PersistenceException {
		List<co.edu.udistrital.entidades.Vehiculo> listavehiculos = daoFactory.getVehiculosDAOImpl().findAllVehiculos();
		return listavehiculos;

	}

	@Override

	public co.edu.udistrital.entidades.Vehiculo crearVehiculo(co.edu.udistrital.entidades.Vehiculo vehiculo)
			throws PersistenceException {
		return daoFactory.getVehiculosDAOImpl().create(vehiculo);
	}

	@Override
	public co.edu.udistrital.entidades.Vehiculo actualizarVehiculo(co.edu.udistrital.entidades.Vehiculo vehiculo)
			throws PersistenceException {
		return daoFactory.getVehiculosDAOImpl().update(vehiculo);
	}

	@Override
	public void borrarVehiculo(co.edu.udistrital.entidades.Vehiculo vehiculo) throws PersistenceException {
		daoFactory.getVehiculosDAOImpl().delete(vehiculo);

	}
	
	@Override
	public Vehiculo obtenerVehiculosPorPlaca(String placa) throws PersistenceException{
		return daoFactory.getVehiculosDAOImpl().findVehiculoByPLaca(placa);
	}
}
