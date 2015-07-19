package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.Vehiculo;

public interface VehiculosDAO extends GenericDAOInterface<Vehiculo, String> {
	
	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long cedula) throws PersistenceException;
	public List<Vehiculo> findAllVehiculos() throws PersistenceException;
	public Vehiculo findVehiculoByPLaca(String placa) throws PersistenceException;
	
}
