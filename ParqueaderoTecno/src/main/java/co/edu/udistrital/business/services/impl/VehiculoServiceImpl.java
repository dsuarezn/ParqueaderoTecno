package co.edu.udistrital.business.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.udistrital.business.services.VehiculoService;
import co.edu.udistrital.dao.DAOFactory;
import co.edu.udistrital.entidades.Vehiculo;


@Transactional
@Service
@Qualifier("vehiculoServiceImpl")
public class VehiculoServiceImpl extends ServiceCommons implements VehiculoService {

	@Override
	public List<Vehiculo> obtenerVehiculosPorIdentificacion(Long identificacion) {
		return daoFactory.getVehiculosDAOImpl().obtenerVehiculosPorIdentificacion(identificacion);
	}

}
