package co.edu.udistrital.business.services;


import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.entidades.Vehiculo;

public interface VehiculoService {

	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long identificacion)throws PersistenceException;
	
	public Vehiculo obtenerVehiculosPorPlaca(String placa)throws PersistenceException;
	
}
