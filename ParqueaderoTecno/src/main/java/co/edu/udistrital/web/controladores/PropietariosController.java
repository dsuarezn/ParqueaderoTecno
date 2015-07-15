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

import co.edu.udistrital.business.services.PropietarioService;
import co.edu.udistrital.business.services.RoleService;
import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.entidades.Role;
import co.edu.udistrital.entidades.User;
import co.edu.udistrital.web.dto.PropietarioDTO;
import co.edu.udistrital.web.dto.UserWebDTO;

@Controller
@RequestMapping(value="/propietarios")
public class PropietariosController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(PropietariosController.class);
	
	@Autowired
	private PropietarioService PropietarioServiceImpl; 
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar propietarios");
		List<Propietario> listapropietario = PropietarioServiceImpl.findAllPropietarios();
		List<PropietarioDTO> listaPropietarioForm = new ArrayList<PropietarioDTO>();
		for (Propietario propietario : listapropietario) {
			PropietarioDTO form = new PropietarioDTO();
			form.setFoto(propietario.getFoto());
			form.setTipoPropietario(propietario.getTipoPropietario());
			form.setCedula(propietario.getCedula());
			form.setNombre(propietario.getNombre());
			form.setApellido(propietario.getApellido());
			form.setEstado(propietario.getEstado());
			listaPropietarioForm.add(form);
		}			

		model.addAttribute("listPropietario", listaPropietarioForm);
		return "listarPropietarios";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear propietarios");
		PropietarioDTO propietarioDTO = new PropietarioDTO();
		propietarioDTO.setEsCrear(true);			
		model.addAttribute("propietario",propietarioDTO);		
		return "crearPropietarios";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(PropietarioDTO propietario, Model model) {
		logger.info("Entrando a modificar propietario en modo "+(propietario.getEsCrear()?"Creación":"Modificación"));
		if(propietario.getEsCrear()){
			crearPropietario(propietario);
			model.addAttribute("exito","Se ha creado el propietario exitosamente");
		}
		else{
			modificarPropietario(propietario);
			model.addAttribute("exito","Se ha editado el propietario exitosamente");
		}
		return listar(model);
	}
	
	@RequestMapping(value = "/editar/{cedula}", method = RequestMethod.GET)
	public String editarPropietario(@PathVariable long cedula, Model model) {		
		logger.info("Entrando a editar propietario");
		Propietario propietario = PropietarioServiceImpl.buscarPropietarioPorCedula(cedula);
		PropietarioDTO propietarioDTO = new PropietarioDTO();
		propietarioDTO.setCedula(propietario.getCedula());
		propietarioDTO.setNombre(propietario.getNombre());
		propietarioDTO.setApellido(propietario.getApellido());
		propietarioDTO.setTelFijo(propietario.getTelFijo());
		propietarioDTO.setTelMovil(propietario.getTelMovil());
		propietarioDTO.setFoto(propietario.getFoto());
		propietarioDTO.setEstado(propietario.getEstado());
		propietarioDTO.setTipoPropietario(propietario.getTipoPropietario());
		propietarioDTO.setEsCrear(false);
		model.addAttribute("propietario", propietarioDTO);
		return "crearPropietarios";
	}
	
	@RequestMapping(value = "/eliminar/{cedula}", method = RequestMethod.GET)
	public String eliminarPropietario(@PathVariable long cedula, Model model) {
		logger.info("Entrando a eliminar propietario");
		Propietario propietario = PropietarioServiceImpl.buscarPropietarioPorCedula(cedula);
		PropietarioServiceImpl.borrarPropietario(propietario);
		model.addAttribute("exito","Se ha eliminado el propietario exitosamente");
		return listar(model);
	}
	
	private Propietario crearPropietario(PropietarioDTO propietario){
		return PropietarioServiceImpl.crearPropietario(new Propietario(Long.valueOf(propietario.getCedula()),propietario.getApellido(),propietario.getEstado(),"null",propietario.getNombre(),propietario.getTelFijo(),propietario.getTelMovil(),propietario.getTipoPropietario()));
	}
	
	private Propietario modificarPropietario(PropietarioDTO propietario){
		return PropietarioServiceImpl.actualizarPropietario(new Propietario(Long.valueOf(propietario.getCedula()),propietario.getApellido(),propietario.getEstado(),"null",propietario.getNombre(),propietario.getTelFijo(),propietario.getTelMovil(),propietario.getTipoPropietario()));
	}
}
