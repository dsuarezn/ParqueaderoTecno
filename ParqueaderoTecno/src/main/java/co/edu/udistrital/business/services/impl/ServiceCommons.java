package co.edu.udistrital.business.services.impl;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import co.edu.udistrital.dao.DAOFactory;


public abstract class ServiceCommons {

	@Autowired
	protected DAOFactory daoFactory;
	
	@Autowired
	protected MessageSource messageSource;
	
	protected Locale locale;	
	public ServiceCommons() {
		super();
		locale = LocaleContextHolder.getLocale();
	}

}
