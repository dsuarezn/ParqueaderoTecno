package co.edu.udistrital.web.controladores;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.edu.udistrital.entidades.Propietario;
import co.edu.udistrital.web.dto.PropietarioDTO;

@Controller
@RequestMapping(value="/propietarios")
public class PropietariosController extends CommonController {

	private static final Logger logger = LoggerFactory.getLogger(PropietariosController.class);
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		logger.info("Devolviendo la vista de listar propietarios");
		List<Propietario> listapropietario = propietarioServiceImpl.findAllPropietarios();
		List<PropietarioDTO> listaPropietarioForm=new ArrayList<PropietarioDTO>();
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
	
	HttpServletRequest request;
		
	@RequestMapping(value = "/modificarAction", method = RequestMethod.POST)
	public String modificar(PropietarioDTO propietario, Model model,  @RequestParam("file") MultipartFile file) {
		logger.info("Entrando a modificar propietario en modo "+(propietario.getEsCrear()?"Creación":"Modificación"));
		Propietario resultPropietario = null;
		try {
			resultPropietario = propietarioServiceImpl.buscarPropietarioPorCedula(propietario.getCedula());
		} catch (PersistenceException e) {
			logger.info("Propietario existente");
		}
		
		if(propietario.getEsCrear() && resultPropietario!=null){
			model.addAttribute("error","Actualmente ya existe un propietario con ese número de cédula, por favor inténtelo de nuevo...");
		} else if(!propietario.getEsCrear() && file.isEmpty() && resultPropietario.getFoto() != null){
			propietario.setFoto(resultPropietario.getFoto());
			modificarPropietario(propietario);
			model.addAttribute("exito","Se ha editado el propietario exitosamente");
		} else {
			while (!file.isEmpty()) {
				try {
					byte[] bytes = file.getBytes();
			        // Creating the directory to store file
			        String rootPath = "C:/Users/Adriana/git/ParqueaderoTecno/ParqueaderoTecno/src/main/webapp/resources/photos";
			        File dir = new File(rootPath);
			        if (!dir.exists())
			        	dir.mkdirs();
			        // Create the file on server
			        File serverFile = new File(dir.getAbsolutePath() + File.separator + propietario.getCedula() + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
			        propietario.setFoto(serverFile.getName());
			        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			        stream.write(bytes);
			        stream.close();
			        logger.info("Server File Location=" + serverFile.getAbsolutePath());
			    } catch (Exception e) {
			      	logger.info("No se ha podido cargar la foto!");
			    }
				break;
			}
						
			if(propietario.getEsCrear()){
				crearPropietario(propietario);
				model.addAttribute("exito","Se ha creado el propietario exitosamente");
			} else {
				modificarPropietario(propietario);
				model.addAttribute("exito","Se ha editado el propietario exitosamente");
			}
		}
		return listar(model);
	}
	
	@RequestMapping(value = "/editar/{cedula}", method = RequestMethod.GET)
	public String editarPropietario(@PathVariable long cedula, Model model) {		
		logger.info("Entrando a editar propietario");
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(cedula);
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
		Propietario propietario = propietarioServiceImpl.buscarPropietarioPorCedula(cedula);
		propietarioServiceImpl.borrarPropietario(propietario);
		
		//Eliminar imagen
		String path = "C:/Users/Adriana/git/ParqueaderoTecno/ParqueaderoTecno/src/main/webapp/resources/photos";
		File directorio = new File(path);
		File archivo = new File(directorio.getAbsolutePath() + File.separator + propietario.getFoto());
		if (archivo.delete())
			logger.info("El fichero ha sido borrado satisfactoriamente");
		else
			logger.info("El fichero no puede ser borrado, ubicacion=" + archivo.getAbsolutePath());
		
		model.addAttribute("exito","Se ha eliminado el propietario exitosamente");
		return listar(model);
	}
	
	private Propietario crearPropietario(PropietarioDTO propietario){
		return propietarioServiceImpl.crearPropietario(new Propietario(Long.valueOf(propietario.getCedula()),propietario.getApellido(),propietario.getEstado(),propietario.getFoto(),propietario.getNombre(),propietario.getTelFijo(),propietario.getTelMovil(),propietario.getTipoPropietario()));
	}
	
	private Propietario modificarPropietario(PropietarioDTO propietario){
		return propietarioServiceImpl.actualizarPropietario(new Propietario(Long.valueOf(propietario.getCedula()),propietario.getApellido(),propietario.getEstado(),propietario.getFoto(),propietario.getNombre(),propietario.getTelFijo(),propietario.getTelMovil(),propietario.getTipoPropietario()));
	}
}
