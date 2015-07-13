package co.edu.udistrital.business.services;


import java.util.List;

import co.edu.udistrital.entidades.Vehiculo;

public interface VehiculoService {

	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long identificacion);
	
}
