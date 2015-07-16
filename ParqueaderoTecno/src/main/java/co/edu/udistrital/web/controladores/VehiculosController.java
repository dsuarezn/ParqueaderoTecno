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

import co.edu.udistrital.business.services.VehiculoService;
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
//			form.setTipovehiculo(vehiculo());
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
		model.addAttribute("vehiculo",vehiculoDTO);		
		return "crearVehiculos";
	}
	
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(VehiculoDTO vehiculo, Model model) {
		logger.info("Entrando a modificar vehiculo en modo "+(vehiculo.getEsCrear()?"Creación":"Modificación"));
		
			crearVehiculo(vehiculo);

		return listar(model);
	}
	
	private Vehiculo crearVehiculo(VehiculoDTO vehiculo){
		return VehiculoServiceImpl.crearVehiculo(new Vehiculo(vehiculo.getPlaca(),vehiculo.getMarca(),vehiculo.getLinea()));
	}

}
