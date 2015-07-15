package co.edu.udistrital.business.services;

import java.util.List;

import javax.persistence.PersistenceException;

import co.edu.udistrital.entidades.Ingreso;
import co.edu.udistrital.web.dto.RegistroFormDTO;


public interface IngresoService {
	
	public Ingreso obtenerRegistroActivoPorPlaca(String placa) throws PersistenceException;
	
	public Ingreso crearIngreso(Ingreso ingreso) throws PersistenceException;	
	
	public void borrarIngreso(Ingreso ingreso) throws PersistenceException;
	
	public Ingreso actualizarIngreso(Ingreso ingreso) throws PersistenceException;
	
	public List<Ingreso> filtrarIngresosByParametros(RegistroFormDTO filtroDTO) throws PersistenceException;

}
