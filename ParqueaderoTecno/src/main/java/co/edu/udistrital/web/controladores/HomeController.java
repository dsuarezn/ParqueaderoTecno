package co.edu.udistrital.web.controladores;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Usuario intentando registro ");

		
		return "login";
	}
	
//	//Spring Security see this :
//		@RequestMapping(value = "/login", method = RequestMethod.GET)
//		public ModelAndView login(
//			@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout) {
//	 
//			logger.info("Tratando de registrarse");
//			
//			ModelAndView model = new ModelAndView();
//			if (error != null) {
//				model.addObject("error", "Invalid username and password!");
//			}
//	 
//			if (logout != null) {
//				model.addObject("msg", "You've been logged out successfully.");
//			}
//			model.setViewName("login");
//	 
//			return model;
//	 
//		}
		
		
	
}
