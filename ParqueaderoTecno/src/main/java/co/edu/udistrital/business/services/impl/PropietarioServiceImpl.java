package co.edu.udistrital.business.services.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.business.services.CustomUserDetailsService;
import co.edu.udistrital.business.services.PropietarioService;
import co.edu.udistrital.dao.DAOFactory;
import co.edu.udistrital.entidades.Propietario;


@Transactional
@Service
@Qualifier("propietarioServiceImpl")
public class PropietarioServiceImpl extends ServiceCommons implements PropietarioService {
	
	
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, PersistenceException {
		co.edu.udistrital.entidades.User buser = daoFactory.getUserDAOImpl().findUserByName(username);		
		if(buser==null){
			throw new UsernameNotFoundException(messageSource.getMessage("UsernameNotFoundException",null,locale));
		}		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Role role = buser.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getNombre()));		
		UserDetails userdetails = new User(buser.getUsername(),buser.getPassword(),authorities);		
		return userdetails;
	}*/

	
	@Override
	public List<co.edu.udistrital.entidades.Propietario> findAllPropietarios() throws PersistenceException {
		List<co.edu.udistrital.entidades.Propietario> listapropietario = daoFactory.getPropietarioDAOImpl().findAllPropietarios();
		return listapropietario;
	}

	
	@Override
	public co.edu.udistrital.entidades.Propietario crearPropietario(co.edu.udistrital.entidades.Propietario propietario) throws PersistenceException {
		return daoFactory.getPropietarioDAOImpl().create(propietario);		
	}
/*
	@Override
	public co.edu.udistrital.entidades.User actualizarUsuario(co.edu.udistrital.entidades.User usuario) throws PersistenceException {		
			return daoFactory.getUserDAOImpl().update(usuario);
	}

	@Override
	public void borrarUsuario(co.edu.udistrital.entidades.User usuario) throws PersistenceException {
		daoFactory.getUserDAOImpl().delete(usuario);
	}
*/


	@Override
	public Propietario findPropietarioById(Long Id)
			throws PersistenceException {
		return daoFactory.getPropietarioDAOImpl().findPropietariosById(Id);
		
	}
}
