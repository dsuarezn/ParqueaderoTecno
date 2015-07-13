package co.edu.udistrital.web.controladores;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.udistrital.entidades.Role;
import co.edu.udistrital.web.dto.RegistroDTO;
import co.edu.udistrital.web.dto.UserWebDTO;

@Controller
@RequestMapping(value="/registro")
public class RegistroController extends CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistroController.class);

	
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear registro");
		RegistroDTO dto=new RegistroDTO();
		model.addAttribute("registro", dto);
		return "crearRegistro";
	}
	
	@RequestMapping(value = "/consultarUsuario", method = RequestMethod.GET)
	public @ResponseBody RegistroDTO consultarUsuario(RegistroDTO dto, Model model) {
		logger.info("Consultando la info del usuario y devolviendo resultado");
		//dto.setListaVehiculos(vehiculoServiceImpl.obtenerVehiculosPorIdentificacion(dto.getCedula()));
		return dto;
	}
	

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarRegistros(Model model) {
		logger.info("Devolviendo la vista de crear registro");
		
		
		
		return "listarRegistro";
	}
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.GET)
	public String modificar(Model model) {
		logger.info("Ingresando a la creación del registro");
		
		
		
		return listarRegistros(model);
	}
	
}
