package co.edu.udistrital.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.VehiculosDAO;
import co.edu.udistrital.entidades.Vehiculo;

@Repository
@Qualifier("vehiculosDAOImpl")
public class VehiculosDAOImpl extends GenericDAOJPAImpl<Vehiculo, String> implements VehiculosDAO {

}
