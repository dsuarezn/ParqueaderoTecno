package co.edu.udistrital.web.controladores;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

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
	
	@Autowired 
	protected ApplicationContext appContext;
	
	@Autowired
	protected ServletContext servletContext;
	
	@Autowired
	protected JasperReportsPdfView jasperReportsPdfView;
	
	protected Locale locale;	
	public CommonController() {
		super();
		locale = LocaleContextHolder.getLocale();
	}
	
}
