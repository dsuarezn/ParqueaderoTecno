package co.edu.udistrital.web.controladores;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;

import co.edu.udistrital.business.services.*;


public class CommonController {

	@Autowired
	protected CustomUserDetailsService customUserDetailsServiceImpl; 
	
	@Autowired
	protected RoleService roleServiceImpl;
	
	@Autowired
	protected VehiculoService vehiculoServiceImpl;
	
	@Autowired
	protected PropietarioService propietarioServiceImpl;
	
	@Autowired
	protected IngresoService ingresoServicioImpl;
	
	protected Locale locale;	
	public CommonController() {
		super();
		locale = LocaleContextHolder.getLocale();
	}
	
}
