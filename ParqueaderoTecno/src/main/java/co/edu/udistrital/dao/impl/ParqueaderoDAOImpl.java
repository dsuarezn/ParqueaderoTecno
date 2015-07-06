package co.edu.udistrital.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.ParqueaderoDAO;
import co.edu.udistrital.entidades.Parqueadero;

@Repository
@Qualifier("parqueaderoDAOImpl")
public class ParqueaderoDAOImpl extends GenericDAOJPAImpl<Parqueadero, String> implements ParqueaderoDAO {

}
