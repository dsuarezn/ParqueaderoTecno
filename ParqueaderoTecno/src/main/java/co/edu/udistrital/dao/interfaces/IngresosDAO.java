package co.edu.udistrital.dao.interfaces;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import co.edu.udistrital.dao.GenericDAOInterface;
import co.edu.udistrital.entidades.Ingreso;
import co.edu.udistrital.web.dto.RegistroFormDTO;


public interface IngresosDAO extends GenericDAOInterface<Ingreso, Long> {

	
	public Ingreso findIngresoActivoByPlaca(String placa) throws PersistenceException;
	
	public List<Ingreso> findIngresoByFilters(RegistroFormDTO filtrodto) throws PersistenceException;
	
}
