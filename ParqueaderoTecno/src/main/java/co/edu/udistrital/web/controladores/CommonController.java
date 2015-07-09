package co.edu.udistrital.web.controladores;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public class CommonController {

	protected Locale locale;	
	public CommonController() {
		super();
		locale = LocaleContextHolder.getLocale();
	}
	
}
