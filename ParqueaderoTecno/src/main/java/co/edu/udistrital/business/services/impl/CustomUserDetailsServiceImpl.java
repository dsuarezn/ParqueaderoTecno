package co.edu.udistrital.business.services.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udistrital.business.services.CustomUserDetailsService;
import co.edu.udistrital.dao.interfaces.UserDAO;
import co.edu.udistrital.entidades.Role;

import org.springframework.security.core.userdetails.User;


@Service
@Qualifier("customUserDetailsServiceImpl")
public class CustomUserDetailsServiceImpl extends ServiceCommons implements CustomUserDetailsService {

	@Autowired
	private UserDAO userDAOImpl;	
	
	@Autowired
	private MessageSource messageSource;
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, PersistenceException {
		co.edu.udistrital.entidades.User buser = userDAOImpl.findUserByName(username);		
		if(buser==null){
			throw new UsernameNotFoundException(messageSource.getMessage("UsernameNotFoundException",null,locale));
		}		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Role role = buser.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getNombre()));		
		UserDetails userdetails = new User(buser.getUsername(),buser.getPassword(),authorities);		
		return userdetails;
	}

}
