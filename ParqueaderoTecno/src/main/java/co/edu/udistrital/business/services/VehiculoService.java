package co.edu.udistrital.business.services;


import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.entidades.Vehiculo;

public interface VehiculoService {
	
	public List<Vehiculo> findAllVehiculos() throws PersistenceException;

	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long identificacion);
	
	public Vehiculo crearVehiculo(Vehiculo vehiculo) throws PersistenceException;
	
	public Vehiculo actualizarVehiculo(Vehiculo vehiculo) throws PersistenceException;
	
	public void borrarVehiculo(Vehiculo vehiculo) throws PersistenceException;
	
}
