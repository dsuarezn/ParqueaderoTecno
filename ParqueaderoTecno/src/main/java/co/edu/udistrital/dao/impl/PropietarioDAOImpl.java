package co.edu.udistrital.dao.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import co.edu.udistrital.dao.GenericDAOJPAImpl;
import co.edu.udistrital.dao.interfaces.PropietarioDAO;
import co.edu.udistrital.entidades.Propietario;

@Repository
@Qualifier("propietarioDAOImpl")
public class PropietarioDAOImpl extends GenericDAOJPAImpl<Propietario, Long> implements PropietarioDAO{

}