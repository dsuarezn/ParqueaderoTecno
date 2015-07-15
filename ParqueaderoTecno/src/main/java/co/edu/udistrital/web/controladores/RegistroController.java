package co.edu.udistrital.web.controladores;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.edu.udistrital.entidades.Ingreso;
import co.edu.udistrital.entidades.Parqueadero;
import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.entidades.Vehiculo;
import co.edu.udistrital.web.dto.RegistroDTO;
import co.edu.udistrital.web.dto.RegistroFormDTO;



@Controller
@RequestMapping(value="/registro")
public class RegistroController extends CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegistroController.class);
	private final String PLACA_CONST="PLACA";
	private final String CEDULA_CONST="CEDULA";
	private final String COMBO_CONST="COMBO";
	
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear registro");
		RegistroDTO dto=new RegistroDTO();
		model.addAttribute("registro", dto);
		return "crearRegistro";
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listarRegistros(Model model) {
		logger.info("Devolviendo la vista de crear registro");
		RegistroFormDTO formdto = new RegistroFormDTO();
		List<Ingreso> listaIngresos=  (List<Ingreso>) ingresoServicioImpl.filtrarIngresosByParametros(formdto);
		model.addAttribute("registros",formdto);
		model.addAttribute("listaRegistros", listaIngresos);
		return "listarRegistro";
	}
	
	@RequestMapping(value = "/listarFiltro", method = RequestMethod.POST)
	public String listarRegistrosPost(@ModelAttribute("formFiltroConsulta") RegistroFormDTO registro ,Model model) {
		logger.info("Devolviendo la vista de crear registro por filtro");		
		List<Ingreso> listaIngresos=  (List<Ingreso>) ingresoServicioImpl.filtrarIngresosByParametros(registro);
		model.addAttribute("registros",registro);
		model.addAttribute("listaRegistros", listaIngresos);
		return "listarRegistro";
	}
	
	@RequestMapping(value = "/consultarUsuario", method = RequestMethod.POST, produces="application/json")
	@ResponseBody
	public RegistroDTO obtenerInfoConsulta(RegistroDTO registro, Model model){
		logger.info("Devolviendo informacion para llenar formulario");
		System.out.println("registro:"+registro.toString());		
		if(registro.getCampoEnviado().equals(PLACA_CONST)){
			if(StringUtils.hasText(registro.getPlaca())){
				Vehiculo vehiculo = vehiculoServiceImpl.obtenerVehiculosPorPlaca(registro.getPlaca());
				if(vehiculo!=null){
					registro.setCedula(vehiculo.getPropietario().getCedula());					
					Ingreso ingreso = ingresoServicioImpl.obtenerRegistroActivoPorPlaca(registro.getPlaca());										
					if(ingreso!=null){
						registro.setEsIngreso("ES_SALIDA");
						registro.setFechaIngreso(ingreso.getFechaEntrada());
						registro.setObservacion(ingreso.getObservacion());
					}
					else{
						registro.setEsIngreso("ES_INGRESO");
					}									
					Propietario propietario = propietarioServiceImpl.findPropietarioById(registro.getCedula());
					if(propietario!=null){												
						registro.setNombresyApellidos(propietario.getNombre()+" "+propietario.getApellido());	
						registro.setObservacion("");				
					}
				}				
			}			
		}		

		
		return registro;
	}
	
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.GET)
	public String modificar(RegistroDTO registro, Model model) {
		logger.info("Ingresando a la creación del registro");
		Ingreso ingreso = new Ingreso();
		if(registro.getEsIngreso().equalsIgnoreCase("ES_INGRESO")){
			Propietario propietario= propietarioServiceImpl.findPropietarioById(registro.getCedula());
			Vehiculo vehiculo = vehiculoServiceImpl.obtenerVehiculosPorPlaca(registro.getPlaca());
			ingreso.setEstado(true);
			ingreso.setFechaEntrada(registro.getFechaIngreso());			
			ingreso.setObservacion(registro.getObservacion());			
			ingreso.setParqueadero(new Parqueadero("AUTOMOVILES",30));
			ingreso.setPropietario(propietario);			
			ingreso.setVehiculo(vehiculo);			
			ingresoServicioImpl.crearIngreso(ingreso);
			
		}
		else if(registro.getEsIngreso().equalsIgnoreCase("ES_SALIDA")) 
		{
			Ingreso registroEntrada = ingresoServicioImpl.obtenerRegistroActivoPorPlaca(registro.getPlaca());			
			registroEntrada.setFechaSalida(registro.getFechaSalida());
			registroEntrada.setEstado(false);						
			registroEntrada.setObservacion(registro.getObservacion());			
			ingreso.setParqueadero(new Parqueadero("AUTOMOVILES",30));
			ingresoServicioImpl.actualizarIngreso(registroEntrada);
			
		}				
		return listarRegistros(model);
	}
	
	public List<String> obtenerListaPlacas(List<Vehiculo> listaVehiculos){
		List<String> listaPlacas= new ArrayList<String>();
		for (Vehiculo vehiculo : listaVehiculos) {
			listaPlacas.add(vehiculo.getPlaca());
		}		
		return listaPlacas;
	}
	
}
