package co.edu.udistrital.web.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.edu.udistrital.business.services.VehiculoService;
import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.entidades.Vehiculo;
import co.edu.udistrital.web.dto.VehiculoDTO;

@Controller
@RequestMapping(value="/vehiculos")
public class VehiculosController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(VehiculosController.class);
	
	@Autowired
	private VehiculoService VehiculoServiceImpl; 
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar vehiculos");
		List<Vehiculo> listavehiculo = VehiculoServiceImpl.findAllVehiculos();
		List<VehiculoDTO> listaVehiculoForm=new ArrayList<VehiculoDTO>();
		for (Vehiculo vehiculo : listavehiculo) {
			VehiculoDTO form = new VehiculoDTO();
			form.setPlaca(vehiculo.getPlaca());
			form.setMarca(vehiculo.getMarca());
			form.setLinea(vehiculo.getLinea());
			form.setCedula(vehiculo.getPropietario().getCedula());
        	form.setTipovehiculo(vehiculo.getTipovehiculo());
        	form.setNombreCompletoPropietario(vehiculo.getPropietario().getNombre()+" "+vehiculo.getPropietario().getApellido());
			listaVehiculoForm.add(form);
		}	

		model.addAttribute("listVehiculo", listaVehiculoForm);
		return "listarVehiculos";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String vistaCrear(Model model) {
		logger.info("Devolviendo la vista de crear vehiculos");
		VehiculoDTO vehiculoDTO = new VehiculoDTO();
		vehiculoDTO.setEsCrear(true);						
		List<Propietario> listaPropietario = propietarioServiceImpl.findAllPropietarios();
		model.addAttribute("listaPropietarios", listaPropietario);
		model.addAttribute("vehiculo",vehiculoDTO);
		return "crearVehiculos";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(VehiculoDTO vehiculo, Model model) {
		logger.info("Devolviendo la vista en modificar");
		Vehiculo resultVehiculo=null;
		try {
			resultVehiculo = VehiculoServiceImpl.obtenerVehiculosPorPlaca(vehiculo.getPlaca());
		} catch (PersistenceException e) {
			logger.info("Usuario existente");
		}
		
		if(vehiculo.getEsCrear()){
			if (resultVehiculo != null){
				model.addAttribute("error","Actualmente ya existe un vehículo con esa placa, por favor inténtelo de nuevo...");
			} else{
				crearVehiculo(vehiculo);
				model.addAttribute("exito","Se ha creado el vehículo exitosamente");
			}			
		} else{
			modificarVehiculo(vehiculo);
			model.addAttribute("exito","Se ha editado el vehículo exitosamente");
		}
		return listar(model);
	}
	
	@RequestMapping(value = "/editar/{placa}", method = RequestMethod.GET)
	public String editarVehiculo(@PathVariable String placa, Model model) {		
		logger.info("Entrando a editar vehiculo");
		Vehiculo vehiculo = VehiculoServiceImpl.obtenerVehiculosPorPlaca(placa);
		VehiculoDTO vehiculoDTO = new VehiculoDTO();
		vehiculoDTO.setPlaca(vehiculo.getPlaca());
		vehiculoDTO.setMarca(vehiculo.getMarca());
		vehiculoDTO.setLinea(vehiculo.getLinea());
		
		vehiculoDTO.setCedula(vehiculo.getPropietario().getCedula());
		vehiculoDTO.setTipovehiculo(vehiculo.getTipovehiculo());
		
		vehiculoDTO.setEsCrear(false);
		model.addAttribute("vehiculo", vehiculoDTO);
		List<Propietario> listaPropietario = propietarioServiceImpl.findAllPropietarios();
		model.addAttribute("listaPropietarios", listaPropietario);

		return "crearVehiculos";
	}
	
	@RequestMapping(value = "/eliminar/{placa}", method = RequestMethod.GET)
	public String eliminarVehiculo(@PathVariable String placa, Model model) {
		logger.info("Entrando a eliminar vehiculo");
		Vehiculo vehiculo = VehiculoServiceImpl.obtenerVehiculosPorPlaca(placa);
		VehiculoServiceImpl.borrarVehiculo(vehiculo);
		model.addAttribute("exito","Se ha eliminado el vehiculo exitosamente");
		return listar(model);
	}
	
	private Vehiculo crearVehiculo(VehiculoDTO vehiculo){
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(vehiculo.getCedula());
		return VehiculoServiceImpl.crearVehiculo(new Vehiculo(vehiculo.getPlaca(),vehiculo.getMarca(),vehiculo.getLinea(), propietario,vehiculo.getTipovehiculo()));
	}
	
	private Vehiculo modificarVehiculo(VehiculoDTO vehiculo){
		
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(vehiculo.getCedula());
		return VehiculoServiceImpl.actualizarVehiculo(new Vehiculo(vehiculo.getPlaca(),vehiculo.getMarca(),vehiculo.getLinea(), propietario,vehiculo.getTipovehiculo()));
	}

}
