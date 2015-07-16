package co.edu.udistrital.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
			listaParqueaderoForm.add(maskParqueaderoInDTO(parqueadero));
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
		Parqueadero resultParqueadero  = customParqueaderoDetailsServiceImpl.loadParqueaderoByTipo(parqueadero.getTipoParqueadero());
		if(resultParqueadero.getTipoParqueadero().equalsIgnoreCase(parqueadero.getTipoParqueadero())){	
			model.addAttribute("error","Actualmente ya existe un tipo de parqueadero con ese nombre, por favor inténtelo de nuevo...");
		} else {
			if(parqueadero.getEsCrear()){
				crearParqueadero(parqueadero);
				model.addAttribute("exito","Se ha creado el tipo de parqueadero exitosamente");
			}
			else{
				modificarParqueadero(parqueadero);
				model.addAttribute("exito","Se ha editado el tipo de parqueadero exitosamente");
			}
		}

		return listar(model);
	}

	private Parqueadero crearParqueadero(ParqueaderoDTO parqueadero){
		return customParqueaderoDetailsServiceImpl.crearParqueadero(new Parqueadero(parqueadero.getTipoParqueadero(), parqueadero.getEspacios(), parqueadero.getIngresos(), parqueadero.getEstado()));			
	}
	
	private Parqueadero modificarParqueadero(ParqueaderoDTO parqueadero){
		return customParqueaderoDetailsServiceImpl.actualizarParqueadero(new Parqueadero(parqueadero.getTipoParqueadero(), parqueadero.getEspacios(), parqueadero.getIngresos(), parqueadero.getEstado()));
	}
	
	
	@RequestMapping(value = "/editar/{tipoParqueadero}", method = RequestMethod.GET)
	public String vistaModificar(@PathVariable String tipoParqueadero, Model model) {
		logger.info("Devolviendo la vista de modificar parqueaderos");
		Parqueadero parqueadero=customParqueaderoDetailsServiceImpl.loadParqueaderoByTipo(tipoParqueadero);
		ParqueaderoDTO parqueaderoDTO = maskParqueaderoInDTO(parqueadero);
		parqueaderoDTO.setEsCrear(false);
		model.addAttribute("parqueadero",parqueaderoDTO);		
		return "crearParqueaderos";
	}
	
	
	@RequestMapping(value = "/eliminar/{tipoParqueadero}", method = RequestMethod.GET)
	public String eliminar(@PathVariable String tipoParqueadero, Model model) {
		logger.info("Eliminando parqueadero: "+tipoParqueadero);		
		Parqueadero parqueaderoToDelete  = customParqueaderoDetailsServiceImpl.loadParqueaderoByTipo(tipoParqueadero);
		customParqueaderoDetailsServiceImpl.borrarParqueadero(parqueaderoToDelete);
		
		return listar(model);
	}

	public ParqueaderoDTO maskParqueaderoInDTO(Parqueadero parqueadero) {
		ParqueaderoDTO form = new ParqueaderoDTO();
		form.setTipoParqueadero(parqueadero.getTipoParqueadero());
		form.setEspacios(parqueadero.getEspacios());
		form.setEstado(parqueadero.getEstado());
		form.setIngresos(parqueadero.getIngresos());
		
		return form;
	}
	
}