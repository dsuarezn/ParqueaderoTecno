package co.edu.udistrital.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.udistrital.business.services.CustomParqueaderoDetailService;
import co.edu.udistrital.entidades.Parqueadero;
import co.edu.udistrital.web.dto.ParqueaderoDTO;

@Controller
@RequestMapping(value="/parqueaderos")
public class ParqueaderosController {
	private static final Logger logger = LoggerFactory.getLogger(ParqueaderosController.class);
	
	@Autowired
	private CustomParqueaderoDetailService customParqueaderoDetailsServiceImpl; 
	
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar parqueaderos");
		
		List<Parqueadero> listParqueaderos = customParqueaderoDetailsServiceImpl.findAllParqueaderos();
		
		List<ParqueaderoDTO> listaParqueaderoForm=new ArrayList<ParqueaderoDTO>();
				
		for (Parqueadero parqueadero : listParqueaderos) {
			ParqueaderoDTO form = new ParqueaderoDTO();
			form.setTipoParqueadero(parqueadero.getTipoParqueadero());
			form.setEspacios(parqueadero.getEspacios());
			form.setEstado(parqueadero.getEstado());
			form.setIngresos(parqueadero.getIngresos());
			listaParqueaderoForm.add(form);
		}
		
		model.addAttribute("listParqueadero", listaParqueaderoForm);
		
		return "listarParqueaderos";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear parqueaderos");
		ParqueaderoDTO parqueaderoDTO = new ParqueaderoDTO();
		parqueaderoDTO.setEsCrear(true);
		model.addAttribute("parqueadero",parqueaderoDTO);		
		return "crearParqueaderos";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(ParqueaderoDTO parqueadero, Model model) {
		logger.info("Entrando a modificar parqueadero en modo "+(parqueadero.getEsCrear()?"Creación":"Modificación"));
		if(parqueadero.getEsCrear()){
			crearParqueadero(parqueadero);
		}
		else{
			modificarParqueadero(parqueadero);
		}

		return listar(model);
	}

	private Parqueadero crearParqueadero(ParqueaderoDTO parqueadero){
		return customParqueaderoDetailsServiceImpl.crearParqueadero(new Parqueadero(parqueadero.getTipoParqueadero(), parqueadero.getEspacios(), parqueadero.getIngresos(), parqueadero.getEstado()));			
	}
	
	private Parqueadero modificarParqueadero(ParqueaderoDTO parqueadero){
		return customParqueaderoDetailsServiceImpl.actualizarParqueadero(new Parqueadero(parqueadero.getTipoParqueadero(), parqueadero.getEspacios(), parqueadero.getIngresos(), parqueadero.getEstado()));
	}
	
	
	@RequestMapping(value = "/modificar", method = RequestMethod.POST)
	public String vistaModificar(ParqueaderoDTO parqueaderoDTO, Model model) {
		logger.info("Devolviendo la vista de modificar parqueaderos");
		parqueaderoDTO.setEsCrear(false);
		model.addAttribute("parqueadero",parqueaderoDTO);		
		return "crearParqueaderos";
	}
	
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(ParqueaderoDTO parqueaderoDTO, Model model) {
		logger.info("Eliminando parqueadero: "+parqueaderoDTO.getTipoParqueadero());		
		Parqueadero parqueaderoToDelete  = customParqueaderoDetailsServiceImpl.loadParqueaderoByTipo(parqueaderoDTO.getTipoParqueadero());
		customParqueaderoDetailsServiceImpl.borrarParqueadero(parqueaderoToDelete);
		
		return listar(model);
	}

}
