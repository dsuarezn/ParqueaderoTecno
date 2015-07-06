package co.edu.udistrital.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.IngresosDAO;
import co.edu.udistrital.entidades.Ingreso;

@Repository
@Qualifier("ingresosDAOImpl")
public class IngresosDAOImpl extends GenericDAOJPAImpl<Ingreso, Long> implements IngresosDAO {

	
	
}
