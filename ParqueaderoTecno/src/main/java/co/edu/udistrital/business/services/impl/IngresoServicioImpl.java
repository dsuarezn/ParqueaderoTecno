package co.edu.udistrital.business.services.impl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.business.services.IngresoService;
import co.edu.udistrital.entidades.Ingreso;
import co.edu.udistrital.web.dto.RegistroFormDTO;

@Transactional
@Service
@Qualifier("ingresoServicioImpl")
public class IngresoServicioImpl extends ServiceCommons implements IngresoService {

	@Override
	public Ingreso obtenerRegistroActivoPorPlaca(String placa)
			throws PersistenceException {
			return daoFactory.getIngresosDAOImpl().findIngresoActivoByPlaca(placa);
	}

	@Override
	public Ingreso crearIngreso(Ingreso ingreso) throws PersistenceException {
		return daoFactory.getIngresosDAOImpl().create(ingreso);
	}

	@Override
	public void borrarIngreso(Ingreso ingreso) throws PersistenceException {
		daoFactory.getIngresosDAOImpl().delete(ingreso);
	}

	@Override
	public Ingreso actualizarIngreso(Ingreso ingreso)
			throws PersistenceException {
		return daoFactory.getIngresosDAOImpl().update(ingreso);
	}

	@Override
	public List<Ingreso> filtrarIngresosByParametros(RegistroFormDTO filtroDTO)
			throws PersistenceException {
		return daoFactory.getIngresosDAOImpl().findIngresoByFilters(filtroDTO);
	}

}
