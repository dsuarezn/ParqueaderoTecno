package co.edu.udistrital.web.controladores;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import co.edu.udistrital.business.services.CustomUserDetailsService;
import co.edu.udistrital.business.services.RoleService;
import co.edu.udistrital.business.services.VehiculoService;

public class CommonController {

	@Autowired
	protected CustomUserDetailsService customUserDetailsServiceImpl; 
	
	@Autowired
	protected RoleService roleServiceImpl;
	
	@Autowired
	protected VehiculoService vehiculoServiceImpl;
	
	protected Locale locale;	
	public CommonController() {
		super();
		locale = LocaleContextHolder.getLocale();
	}
	
}
