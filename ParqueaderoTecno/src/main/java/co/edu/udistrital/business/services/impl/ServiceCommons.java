package co.edu.udistrital.business.services.impl;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public abstract class ServiceCommons {

	protected Locale locale;	
	public ServiceCommons() {
		super();
		locale = LocaleContextHolder.getLocale();
	}

}
